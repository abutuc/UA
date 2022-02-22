//
// AED, November 2021
//
// Solution of the first practical assignement (subset sum problem)
//
// Place your student numbers and names here
//

#if __STDC_VERSION__ < 199901L
# error "This code must must be compiled in c99 mode or later (-std=c99)" // to handle the unsigned long long data type
#endif
#ifndef STUDENT_H_FILE
# define STUDENT_H_FILE "000000.h"
#endif

// #define BTF_ITR
// #define BTF_RCR_NOTM
// #define BTF_RCR_OTM
#define HW_SN
//#define MIM
//
// include files
//

#include <stdio.h>

#include <stdlib.h>

#include "../P02/elapsed_time.h"

#include STUDENT_H_FILE


//
// custom data types
//
// the STUDENT_H_FILE defines the following constants and data types
//
//   #define min_n       24                   --- the smallest n value we will handle
//   #define max_n       57                   --- the largest n value we will handle
//   #define n_sums      20                   --- the number of sums for each n value
//   #define n_problems  (max_n - min_n + 1)  --- the number of n values
//
//   typedef unsigned long long integer_t;    ---  64-bit unsigned integer
//   typedef struct
//   {
//     int n;                                 --- number of elements of the set (for a valid problem, min_n <= n <= max_n)
//     integer_t p[max_n];                    --- the elements of the set, already sorted in increasing order (only the first n elements are used)
//     integer_t sums[n_sums];                --- several sums (problem: for each sum find the corresponding subset)
//   }
//   subset_sum_problem_data_t;               --- weights p[] and sums for a given value of n
//
//   subset_sum_problem_data_t all_subset_sum_problems[n_problems]; --- // the problems
//

int bruteforce_iterativo(int n, integer_t p[n], integer_t desired_sum, integer_t * b) {
   for (int mask = 0; mask < 1 << n; mask++) {
      integer_t partial_sum = 0;
      for (int bit = 0; bit < n; bit++) {
         if (mask & (1 << bit))
            partial_sum += p[bit];
      }
      if (partial_sum == desired_sum) {
         * b = mask;
         return 1;
      }
   }
   return 0;
}

int bruteforce_recursivo(int n, integer_t p[n], int level, integer_t partial_sum, integer_t desired_sum, integer_t mask, integer_t * b) {
   if (level > n) {
      return 0;
   }
   if (partial_sum == desired_sum) {
      * b = mask;
      return 1;
   }

   if (bruteforce_recursivo(n, p, level + 1, partial_sum + p[level], desired_sum, (mask | (1 << level)), b)) {
      return 1;
   } else {
      return bruteforce_recursivo(n, p, level + 1, partial_sum, desired_sum, mask, b);
   }

}

int bruteforce_recursivo_otimizado(int n, integer_t p[n], int level, integer_t partial_sum, integer_t desired_sum, integer_t mask, integer_t * b, integer_t * sums) {
   if (partial_sum == desired_sum) {
      * b = mask;
      return 1;
   }

   if (level < 0 || partial_sum > desired_sum || partial_sum + sums[level] < desired_sum) {
      return 0;
   }

   if (bruteforce_recursivo_otimizado(n, p, level - 1, partial_sum + p[level], desired_sum, (mask | (1 << (level))), b, sums)) {
      return 1;
   } else {
      return bruteforce_recursivo_otimizado(n, p, level - 1, partial_sum, desired_sum, mask, b, sums);
   }
}

typedef struct {
   integer_t mask;
   integer_t sum;
}
mask_data_t;

void swap(mask_data_t * a, mask_data_t * b) {
   mask_data_t t = * a;
   * a = * b;
   * b = t;
}

int partition(mask_data_t arr[], int low, int high) {
   mask_data_t pivot = arr[high]; // pivot
   int i = (low - 1); // Index of smaller element and indicates the right position of pivot found so far

   for (int j = low; j <= high - 1; j++) {
      // If current element is smaller than the pivot
      if (arr[j].sum < pivot.sum) {
         i++; // increment index of smaller element
         swap( & arr[i], & arr[j]);
      }
   }
   swap( & arr[i + 1], & arr[high]);
   return (i + 1);
}

void quicksort(mask_data_t arr[], int low, int high) {
   if (low < high) {
      /* pi is partitioning index, arr[p] is now
      at right place */
      int pi = partition(arr, low, high);
      // Separately sort elements before
      // partition and after partition
      quicksort(arr, low, pi - 1);
      quicksort(arr, pi + 1, high);
   }
}


void sums_generator(int n, integer_t p[n], mask_data_t result[1 << n], int level, integer_t mask, integer_t subSum, int idx) {
    if (level == n)
    {
        result[idx].sum = subSum;
        result[idx].mask = mask;
        return;
    }

    sums_generator(n, p, result, level + 1, mask | (1 << level), subSum + p[level], 2*idx);
    sums_generator(n, p, result, level + 1, mask, subSum, 2*idx+1);
}



int horowitz_sahni(int n, integer_t p[], integer_t desired_sum, integer_t * b_result) {
   int nA = n / 2;
   int nB = n - nA;
   integer_t *a,*b;
   a = p;
   b = p + nA;
   mask_data_t * sumsA = malloc((1 << nA) * sizeof(mask_data_t));
   mask_data_t * sumsB = malloc((1 << nB) * sizeof(mask_data_t));

   sums_generator(nA, a, sumsA, 0, 0, 0, 0);
   quicksort(sumsA, 0, (1 << nA) - 1);
   
   sums_generator(nB, b, sumsB, 0, 0, 0, 0);
   quicksort(sumsB, 0, (1 << nB) - 1);

   int i = 0, j = (1 << nB) - 1;

   while (i < (1 << nA) && j >= 0) {
      if (sumsA[i].sum + sumsB[j].sum == desired_sum) {
         *b_result = sumsA[i].mask | (sumsB[j].mask << nA);
         free(sumsA);
         free(sumsB);
         return 1;
      } else if (sumsA[i].sum + sumsB[j].sum < desired_sum) {
         i++;
      } else {
         j--;
      }
   }
   return 0;
}

typedef struct {
   integer_t mask;
   integer_t sum;
   int i0;
   int i1;
} heapData_t;

void minheapInsert(heapData_t heap[], heapData_t element, int* heapSize)
{
    int i;
    for (i = *heapSize; i > 0 && heap[(i - 1) / 2].sum > element.sum; i = (i - 1) / 2)
    {
        heap[i] = heap[(i - 1) / 2];
    }
    heap[i] = element;
    (*heapSize)++;
}

heapData_t deleteMin(heapData_t heap[], int* heapSize)
{
   int i, son;
   heapData_t element = heap[0];

   (*heapSize)--;
   for (i = 0; i * 2 + 1 <= *heapSize; i = son) {
      son = 2 * i + 1;
      if (son < *heapSize && heap[son].sum > heap[son + 1].sum)
         son++;
      if (heap[son].sum < heap[*heapSize].sum)
         heap[i] = heap[son];
      else
         break;
   }

   heap[i] = heap[*heapSize];
   return element;
}

void maxheapInsert(heapData_t heap[], heapData_t element, int* heapSize)
{
   int i;
   for (i = *heapSize; i > 0 && heap[(i - 1) / 2].sum < element.sum; i = (i - 1) / 2) {
      heap[i] = heap[(i - 1) / 2];
   }
   heap[i] = element;
   (*heapSize)++;
}

heapData_t deletemax(heapData_t heap[], int* heapSize)
{
   int i, son;
   heapData_t element = heap[0];

   (*heapSize)--;
   for (i = 0; i * 2 + 1 <= *heapSize; i = son) {
      son = 2 * i + 1;
      if (son < *heapSize && heap[son].sum < heap[son + 1].sum)
         son++;
      if (heap[son].sum > heap[*heapSize].sum)
         heap[i] = heap[son];
      else
         break;
   }
   heap[i] = heap[*heapSize];
   return element;
}

int schroeppel_shamir (int n, integer_t p[], integer_t desired_sum, integer_t * b_result) {
   int nB = n / 2;
   int nD = n - nB;

   int nA = nB / 2;
   nB -= nA;

   int nC = nD / 2;
   nD -= nC;

   integer_t * a = p;
   integer_t * b = p+nA;
   integer_t * c = p+nA+nB;
   integer_t * d = p+nA+nB+nC;
   mask_data_t * sumsA = malloc((1 << nA) * sizeof(mask_data_t));
   mask_data_t * sumsB = malloc((1 << nB) * sizeof(mask_data_t));
   mask_data_t * sumsC = malloc((1 << nC) * sizeof(mask_data_t));
   mask_data_t * sumsD = malloc((1 << nD) * sizeof(mask_data_t));

   //Para o Array A
   sums_generator(nA, a, sumsA, 0, 0, 0, 0);
   quicksort(sumsA, 0, (1 << nA) - 1);

   //Para o Array B
   sums_generator(nB, b, sumsB, 0, 0, 0, 0);
   quicksort(sumsB, 0, (1 << nB) - 1);
   
   //Para o Array C
   sums_generator(nC, c, sumsC, 0, 0, 0, 0);
   quicksort(sumsC, 0, (1 << nC) - 1);
   //Para o Array D
   sums_generator(nD, d, sumsD, 0, 0, 0, 0);
   quicksort(sumsD, 0, (1 << nD) - 1);

   heapData_t minHeap[1 << nB];
   heapData_t maxHeap[1 << nC];
   int nHMin = 0;
   int nHMax = 0;

   for (int i = 0; i < (1 << nB); i++) {
      heapData_t sum = {
         .mask = sumsA[0].mask | (sumsB[i].mask << nA),
         .sum = sumsA[0].sum + sumsB[i].sum,
         .i0 = 0,
         .i1 = i
      };
      minheapInsert(minHeap, sum, &nHMin);
   }

   for (int i = 0; i < (1 << nC); i++) {
      heapData_t sum = {
         .mask = sumsC[i].mask | (sumsD[(1 << nD) - 1].mask << nC),
         .sum = sumsC[i].sum + sumsD[(1 << nD) - 1].sum,
         .i0 = i,
         .i1 = (1 << nD) - 1
      };
      maxheapInsert(maxHeap,sum,&nHMax);
   }

   while (nHMin > 0 && nHMax > 0){
      integer_t partial_sum = maxHeap[0].sum + minHeap[0].sum;
      if (partial_sum ==  desired_sum) {
         *b_result = minHeap[0].mask | (maxHeap[0].mask << (nA+nB));
         free(sumsA);
         free(sumsB);
         free(sumsC);
         free(sumsD);
         return 1;
      } else if (partial_sum > desired_sum){
         heapData_t old_max = deletemax(maxHeap,&nHMax);
         old_max.i1--;

         if (old_max.i1 >= 0) {
            heapData_t new = {
               .mask = sumsC[old_max.i0].mask | (sumsD[old_max.i1].mask << nC),
               .sum = sumsC[old_max.i0].sum + sumsD[old_max.i1].sum,
               .i0 = old_max.i0,
               .i1 = old_max.i1
            };
            maxheapInsert(maxHeap,new,&nHMax);
         }
      } else {
         heapData_t old_min = deleteMin(minHeap, &nHMin);
         old_min.i0++;
         if (old_min.i0 < (1 << nA)) {
            heapData_t new = {
               .mask = sumsA[old_min.i0].mask | (sumsB[old_min.i1].mask << nA),
               .sum = sumsA[old_min.i0].sum + sumsB[old_min.i1].sum,
               .i0 = old_min.i0,
               .i1 = old_min.i1
            };
            minheapInsert(minHeap, new, &nHMin);
         }
      }
   }

   free(sumsA);
   free(sumsB);
   free(sumsC);
   free(sumsD);
   return 0;
}



//
// main program
//
int main(void) {
   fprintf(stderr, "Program configuration:\n");
   fprintf(stderr, "  min_n ....... %d\n", min_n);
   fprintf(stderr, "  max_n ....... %d\n", max_n);
   fprintf(stderr, "  n_sums ...... %d\n", n_sums);
   fprintf(stderr, "  n_problems .. %d\n", n_problems);
   fprintf(stderr, "  integer_t ... %d bits\n", 8 * (int) sizeof(integer_t));
   //
   // for each n
   //
   for (int i = 0; i < n_problems; i++) {
      int n = all_subset_sum_problems[i].n; // the value of n
      if (n > 57)
         continue; // skip large values of n
      integer_t * p = all_subset_sum_problems[i].p; // the weights
      //
      // for each sum
      //
      for (int j = 0; j < n_sums; j++) {
         integer_t desired_sum = all_subset_sum_problems[i].sums[j]; // the desired sum
         integer_t b = 0; // array to record the solution

         double start = cpu_time();
         #ifdef BTF_ITR
            bruteforce_iterativo(n, p, desired_sum, & b);
         #endif

         #ifdef BTF_RCR_NOTM
            bruteforce_recursivo(n, p, 0, 0, desired_sum, 0, & b);
         #endif

         #ifdef BTF_RCR_OTM
            integer_t * sums = (integer_t * ) malloc(n * sizeof(integer_t));

            for (int i = 0; i < n; i++) {
               sums[i] = 0;
               for (int j = 0; j <= i; j++) {
                  sums[i] += p[j];
               }
            }
            bruteforce_recursivo_otimizado(n, p, n - 1, 0, desired_sum, 0, &b, sums);
         #endif

         #ifdef HW_SN
            int success = horowitz_sahni(n, p, desired_sum, &b);
            if (success==1){
            printf("Solução encontrada, n=%d.\n", n);
            }
            else {
            printf("Solution not found.\n");
            return 0;
            }
         #endif

         #ifdef MIM
            schroeppel_shamir(n,p,desired_sum, &b);
         #endif

         double end = cpu_time();

        //  for (int i = 0; i < n; i++) {
        //     printf("%s", b & 1 ? "1" : "0");
        //     b = b >> 1;
        //  }
         printf("time: %lf\n", end - start);
      }
      printf("\n");
   }
   return 0;
}