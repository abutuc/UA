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
# define STUDENT_H_FILE "103530.h"
#endif

//
// include files
//

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "../P02/elapsed_time.h"
#include STUDENT_H_FILE

typedef struct
{
  integer_t soma;
  int i0;
  int i1;

} soma_struct;
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


//
// place your code here
//
// possible function prototype for a recursive brute-force function:
//   int brute_force(int n,integer_t p[n],integer_t desired_sum,int current_index,integer_t partial_sum,int b[n]);
// it sould return 1 when the solution is found and 0 otherwise
// note, however, that you may get a faster function by reducing the number of function arguments (maybe a single pointer to a struct?)
//


// ---------------------------------------------- //
void insertion_sort(integer_t *data,int first,int one_after_last)
{
  int i,j;
  for(i = first + 1;i < one_after_last;i++)
  {
    integer_t tmp = data[i];
    for(j = i;j > first && tmp < data[j - 1];j--)
    data[j] = data[j - 1];
    data[j] = tmp;
  }
}
// --------------------------------------------- //

// ---------------------------------------------- //
void merge_sort(integer_t *data,int first,int one_after_last)
{
  int i,j,k,middle;
  integer_t *buffer;
  if(one_after_last - first < 40) // do not allocate less than 40 bytes
    insertion_sort(data,first,one_after_last);
  else
  {
    middle = (first + one_after_last) / 2;
    merge_sort(data,first,middle);
    merge_sort(data,middle,one_after_last);
    buffer = (integer_t *)malloc((size_t)(one_after_last - first) * sizeof(integer_t)) - first; // no error check!
    i = first; // first input (first half)
    j = middle; // second input (second half)
    k = first; // merged output
    while(k < one_after_last)
    if(j == one_after_last || (i < middle && data[i] <= data[j]))
    buffer[k++] = data[i++];
    else
    buffer[k++] = data[j++];
    for(i = first;i < one_after_last;i++)
    data[i] = buffer[i];
    free(buffer + first);
  }
}
// ---------------------------------------------- //

// ---------------------------------------------- //
int sum_all_subsets(int n_sub, integer_t p[n_sub], int current_index, integer_t partial_sum, integer_t **subset){

  if(current_index == n_sub){
    **subset=partial_sum;
    (*subset)++;
    return 0;
  }
  if (sum_all_subsets(n_sub, p, current_index + 1, partial_sum + 0 * p[current_index], subset) != 0){
    return 1;
  }
  if (sum_all_subsets(n_sub, p, current_index + 1, partial_sum + 1 * p[current_index], subset) != 0){
    return 1;
  }
  return 0;
}
// ---------------------------------------------- //

// ---------------------------------------------- //
int clever_brute_force(int n, integer_t p[n], int b[n], integer_t desired_sum, int current_index, integer_t partial_sum, int current_last_index, integer_t bigger_sum){
  if(partial_sum > desired_sum)
    return 0;
  
  if(partial_sum == desired_sum)
    return 1;
  
  if(current_index == n)
    return 0;
  
  if (current_index == current_last_index){
    if (bigger_sum + partial_sum < desired_sum){
      return 0;
    }
  }
  if (clever_brute_force(n, p, b, desired_sum, current_index + 1, partial_sum + 0 * p[current_index], current_last_index - 1, bigger_sum + p[current_last_index]) != 0){
    b[current_index]=0;
    return 1;
    }
  if (clever_brute_force(n, p, b,desired_sum, current_index + 1, partial_sum + 1 * p[current_index], current_last_index - 1, bigger_sum + p[current_last_index]) != 0){
    b[current_index]=1;
    return 1;
    }
  return 0;
}
// ---------------------------------------------- //

// ---------------------------------------------- //
int horowitz_sahni(int n, integer_t p[n], int b[n], integer_t desired_sum, int current_index, integer_t partial_sum){
  int n1 = n/2;
  int n2 = n - n1;
  integer_t p1[n1];
  integer_t p2[n2];
  int length_a = pow(2, n1);
  int length_c = pow(2, n2);
  integer_t *a = malloc(length_a * sizeof(integer_t));
  integer_t *c = malloc(length_c * sizeof(integer_t));
  int solution_a[n1];
  for (int i = 0; i<n1; i++){
    solution_a[i]=0;
  }
  int solution_c[n2];
  for (int i = 0; i<n2; i++){
    solution_c[i]=0;
  }
  for (int i=0; i<n; i++){
    if (i < n/2){
      p1[i] = p[i];
    }
    else {
      p2[i - (n/2)] = p[i];
    }
  }
  integer_t *temp_a = a;
  integer_t *temp_c = c;
  sum_all_subsets(n1, p1, 0, 0, &a);
  sum_all_subsets(n2, p2, 0, 0, &c);
  a = temp_a;
  c = temp_c;
  merge_sort(a, 0, length_a);
  merge_sort(c, 0, length_c);
  c=&c[(int) length_c-1];
  while ((*c + *a) != desired_sum){
    if ((*c + *a) < desired_sum){
      a++;
    } 
    if ((*c + *a) > desired_sum){
      c--;
    } 
    if (a==&temp_a[(int) length_a]){
        free(temp_a);
        free(temp_c);
        return 0;
    }
    if (c==temp_c-1){
      free(temp_a);
      free(temp_c);
      return 0;
    }
  }
  clever_brute_force(n1, p1, solution_a, *a, 0, 0, n1-1, 0);
  clever_brute_force(n2, p2, solution_c, *c, 0, 0, n2-1, 0);
  // for (int i=0; i<n1; i++){
  //   printf("%d ", solution_a[i]);
  // }
  // for (int i=0; i<n2; i++){
  //   printf("%d ", solution_c[i]);
  // }
  // printf("\n");
  free(temp_a);
  free(temp_c);
  return 1;
}
// ---------------------------------------------- //

// ---------------------------------------------- //
int parent(int i) {
    return (i - 1) / 2;
}

// return the index of the left child 
int left_child(int i) {
    return 2*i + 1;
}

// return the index of the right child 
int right_child(int i) {
    return 2*i + 2;
}

// insert the item at the appropriate position

void max_heapify(soma_struct a[], int i, int n){
    int left = left_child(i);
    int right = right_child(i);
    int largest = i;
    if (left <= n && a[left].soma > a[largest].soma) {
        largest = left;
    }
    if (right <= n && a[right].soma > a[largest].soma) {
        largest = right;
    }
    if (largest != i) {
        soma_struct temp = a[i];
        a[i] = a[largest];
        a[largest] = temp;
        max_heapify(a, largest, n);
    }

}

void min_heapify(soma_struct a[], int i, int n){
    int left = left_child(i);
    int right = right_child(i);
    int smallest = i;
    
    if (n > left && a[smallest].soma > a[left].soma) {
        smallest = left;
    }
    if (n > right && a[smallest].soma > a[right].soma) {
        smallest = right;
    }
    if (smallest != i) {
        soma_struct temp = a[smallest];
        a[smallest] = a[i];
        a[i]= temp;
        min_heapify(a, smallest, n);
    }

}

void insert(soma_struct a[], soma_struct data, int *n, int type) {
    // first insert the time at the last position of the array 
    // and move it up
    a[*n] = data;
    *n = *n + 1;

    // move up until the heap property satisfies
    if (type == 0){
      for (int i = *n; i >= 0; i--) {
          min_heapify(a, i, *n);
      } 
    }
    if (type == 1){
      for (int i = *n; i >= 0; i--) {
          max_heapify(a, i, *n);
      } 
    }
}

void build_max_heap(soma_struct a[], int n) {
    for (int i = n/2; i >= 0; i--) {
        max_heapify(a, i, n);
    } 
}

void build_min_heap(soma_struct a[], int n) {
    for (int i = n/2; i >= 0; i--) {
        min_heapify(a, i, n);
    } 
}

// deletes the max item and return
soma_struct extract_max(soma_struct a[], int *n) {
    soma_struct max_item = a[0];

    // replace the first item with the last item
    a[0] = a[*n - 1];
    *n = *n - 1;

    // maintain the heap property by heapifying the 
    // first item
    max_heapify(a, 0, *n);
    return max_item;
}

soma_struct extract_min(soma_struct a[], int *n) {
    soma_struct min_item = a[0];
    // replace the first item with the last item
    a[0] = a[*n - 1];
    *n = *n - 1;

    // maintain the heap property by heapifying the 
    // first item
    min_heapify(a, 0, *n); 
    return min_item;
}


// ---------------------------------------------- //
// int schroeppel_shamir(int n, integer_t p[], integer_t desired_sum){
  
//   // int n1 = n/4 + (n%4)/2;
//   // int n2 = n/4;
//   // int n3 = n/4 + (n%4)/2;
//   // int n4 = n-n1-n2-n3;

//   // integer_t p1[n];
//   // integer_t p2[n2];
//   // integer_t p3[n3];
//   // integer_t p4[n4];

//   // int length_a1 = pow(2, n1);
//   // int length_a2 = pow(2, n2);
//   // int length_b1 = pow(2, n3);
//   // int length_b2 = pow(2, n4);

//   // integer_t *a1 = malloc(length_a1 * sizeof(integer_t));
//   // integer_t *a2 = malloc(length_a2 * sizeof(integer_t));
//   // integer_t *b1 = malloc(length_b1 * sizeof(integer_t));
//   // integer_t *b2 = malloc(length_b2 * sizeof(integer_t));
//   int nB = n / 2;
//   int nD = n - nB;

//   int nA = nB / 2;
//   nB -= nA;

//   int nC = nD / 2;
//   nD -= nC;

//   integer_t * a = p;
//   integer_t * b = p+nA;
//   integer_t * c = p+nA+nB;
//   integer_t * d = p+nA+nB+nC;

//   soma_struct * sumsA = malloc((1 << nA) * sizeof(integer_t));
//   soma_struct * sumsB = malloc((1 << nB) * sizeof(integer_t));
//   soma_struct * sumsC = malloc((1 << nC) * sizeof(integer_t));
//   soma_struct * sumsD = malloc((1 << nD) * sizeof(integer_t));

//   // for (int i=0; i<n; i++){
//   //   if (i < n1){
//   //     p1[i] = p[i];
//   //   }
//   //   else if (i < n1+n2){
//   //     p2[i - n1] = p[i];
//   //   }
//   //   else if (i < n1+n2+n3){
//   //     p3[i - n1 - n2] = p[i];
//   //   }
//   //   else {
//   //     p4[i - n1 - n2 - n3] = p[i];
//   //   }
//   // }

//   // integer_t *temp_a1 = sumsA;
//   // integer_t *temp_a2 = sumsB;
//   // integer_t *temp_b1 = sumsC;
//   // integer_t *temp_b2 = sumsD;

//   // sum_all_subsets(n1, p1, 0, 0, &a1);
//   // sum_all_subsets(n2, p2, 0, 0, &a2);
//   // sum_all_subsets(n3, p3, 0, 0, &b1);
//   // sum_all_subsets(n4, p4, 0, 0, &b2);

//   //Para o Array A
//    sums_generator(nA, a, sumsA, 0, 0, 0);
//    quicksort(sumsA, 0, (1 << nA) - 1);

//    //Para o Array B
//    sums_generator(nB, b, sumsB, 0, 0, 0);
//    quicksort(sumsB, 0, (1 << nB) - 1);
   
//    //Para o Array C
//    sums_generator(nC, c, sumsC, 0, 0, 0);
//    quicksort(sumsC, 0, (1 << nC) - 1);
//    //Para o Array D
//    sums_generator(nD, d, sumsD, 0, 0, 0);
//    quicksort(sumsD, 0, (1 << nD) - 1);

//   // sumsA = temp_a1;
//   // sumsB = temp_a2;
//   // sumsC = temp_b1;
//   // sumsD = temp_b2;

//   // merge_sort(sumsA, 0, (1 << nA) - 1);
//   // merge_sort(sumsB, 0, (1 << nB) - 1);
//   // merge_sort(sumsC, 0, (1 << nC) - 1);
//   // merge_sort(sumsD, 0, (1 << nD) - 1);

//   soma_struct min_heap[1 << nB];
//   int size_min_heap = 0;

//   for (int i = 0; i < (1 << nB); i++){
//     soma_struct sum = {
//       .soma = sumsA[0].soma + sumsB[i].soma,
//       .i0 = 0,
//       .i1 = i
//     };
//     minheapInsert(min_heap, sum, &size_min_heap);
//   }

//   soma_struct max_heap[1 << nC];
//   int size_max_heap = 0;
//   for (int i = 0; i<(1 << nC); i++){
//     soma_struct sum = {
//       .soma = sumsC[i].soma + sumsD[(1 << nD) - 1].soma,
//       .i0 = i,
//       .i1 = (1 << nD) - 1
//     };
//     maxheapInsert(max_heap, sum, &size_max_heap);
//   }

//   //soma_struct elem_a;
//   //soma_struct elem_b;
//   //integer_t sum;
//   //int ret = 0;
//   // printf("Max Heap Inicial: \n");
//   // print_heap(max_heap, size_max_heap);
//   // printf("\n\n");
//   //printf("Desired Sum: %llu\n", desired_sum);
//   while (size_min_heap > 0 && size_max_heap > 0){
//     //elem_a = extract_min(min_heap, &size_min_heap);
//     //printf("elem_a: %llu; indice1: %d: indice2: %d\n", elem_a.soma, elem_a.indice_1, elem_a.indice_2);
//     //elem_b = extract_max(max_heap, &size_max_heap);
//     //printf("elem_b: %llu; indice1: %d: indice2: %d\n", elem_b.soma, elem_b.indice_1, elem_b.indice_2);
//     //sum = elem_a.soma + elem_b.soma;
//     integer_t sum = max_heap[0].soma + min_heap[0].soma;
//     if (sum == desired_sum){
//       free(sumsA);
//       free(sumsB);
//       free(sumsC);
//       free(sumsD);
//       return 1;
//     }

//     else if (sum > desired_sum){
//       soma_struct old_max = deletemax(max_heap, &size_max_heap);
//       old_max.i1--;

//       if (old_max.i1 >=0){
//         soma_struct new = {
//           .soma = sumsC[old_max.i0].soma + sumsD[old_max.i1].soma,
//           .i0 = old_max.i0,
//           .i1 = old_max.i1
//         };
//         maxheapInsert(max_heap, new, &size_max_heap);
//       }
//     }
    
//     else {
//       soma_struct old_min = deleteMin(min_heap, &size_min_heap);
//       old_min.i0++;
//       if (old_min.i0 < (1 << nA)){
//         soma_struct new = {
//           .soma = sumsA[old_min.i0].soma + sumsB[old_min.i0].soma,
//           .i0 = old_min.i0,
//           .i1 = old_min.i1
//         };
//         minheapInsert(min_heap, new, &size_min_heap);
//       }
//     }
//   }
//   free(sumsA);
//   free(sumsB);
//   free(sumsC);
//   free(sumsD);
//   return 0;
// }
//     //printf("Partial Sum: %llu\n", sum);
//   /*
//     if (sum < desired_sum){
//       if (elem_a.indice_2 < length_a2-1){
//         elem_a.indice_2++;
//         elem_a.soma = a1[elem_a.indice_1]+a2[elem_a.indice_2];
//         insert(min_heap, elem_a, &size_min_heap, 0);
//       }
//       insert(max_heap, elem_b, &size_max_heap, 1);
//     }

//     if (sum > desired_sum){
//       if (elem_b.indice_2 > 0){
//         elem_b.indice_2--;
//         elem_b.soma = b1[elem_b.indice_1]+b2[elem_b.indice_2];
//         insert(max_heap, elem_b, &size_max_heap, 1);
//       }
//       insert(min_heap, elem_a, &size_min_heap, 0);
//     }

//     // printf("Min Heap Changed: \n");
//     // print_heap(min_heap, size_min_heap);
//     // printf("\n\n");

//     // printf("Max Heap: \n");
//     // print_heap(max_heap, size_max_heap);
//     if (sum == desired_sum){
//       ret = 1;
//       break;
//     }
//   }

//   // printf("Desired Sum: %llu\n", desired_sum);
//   // printf("Solution: %llu\n", sum);
//   // printf("a: %llu; b: %llu\n", elem_a.soma, elem_b.soma);
//   free(temp_a1);
//   free(temp_a2);
//   free(temp_b1);
//   free(temp_b2);
  

//   return ret;
// }
// */
// ---------------------------------------------- //
// ---------------------------------------------- //
int brute_force(int n, integer_t p[n], int b[n], integer_t desired_sum, int current_index, integer_t partial_sum){
  if(partial_sum == desired_sum)
    return 1;
  
  if(current_index == n)
    return 0;
  
  if (brute_force(n, p, b, desired_sum, current_index + 1, partial_sum + 0 * p[current_index]) != 0){
    b[current_index]=0;
    return 1;
    }
  
  if (brute_force(n, p, b,desired_sum, current_index + 1, partial_sum + 1 * p[current_index]) != 0){
    b[current_index]=1;
    return 1;
    }
  return 0;
}
// ---------------------------------------------- //

// ---------------------------------------------- //
int dumb_force(int n, integer_t p[n], integer_t desired_sum)
{ 
  integer_t test_sum;
  for (int comb=0; comb<(1<<n); comb++)
  {
    test_sum=0;
    for (int bit=0; bit<n; bit++)
    {
        if ((comb & (1 << bit)) != 0)               //00000101 & 00000010 = 00000000 == 0 but, 00000101 & 00000100 = 00000100 == 4
        {
            test_sum += p[bit];
        }
    }
    if (test_sum==desired_sum)
    {
      // Imprime a combinação descoberta
      for (int bit=0; bit<n; bit++)
      {
        if ((comb & (1 << bit)) != 0)               //00000101 & 00000010 = 00000000 == 0 but, 00000101 & 00000100 = 00000100 == 4
        {
          printf("%d ", bit);
        }
    }
      return 1;
    }
  }
  return 0;
}
// ---------------------------------------------- //

//
// main program
//

// ---------------------------------------------- //

int main(void)
{
  fprintf(stderr,"Program configuration:\n");
  fprintf(stderr,"  min_n ....... %d\n",min_n);
  fprintf(stderr,"  max_n ....... %d\n",max_n);
  fprintf(stderr,"  n_sums ...... %d\n",n_sums);
  fprintf(stderr,"  n_problems .. %d\n",n_problems);
  fprintf(stderr,"  integer_t ... %d bits\n",8 * (int)sizeof(integer_t));
  //
  // for each n
  //
  // FILE *fpb = NULL;
  // fpb = fopen("clever_brute_force_data.txt", "w");
  int not_found = 0;
  for(int i = 0;i < n_problems;i++)
  {
    int n = all_subset_sum_problems[i].n; // the value of n
    if(n > 57)
      continue; // skip large values of n
    integer_t *p = all_subset_sum_problems[i].p; // the weights
    //for (int f = 0; f < n; f++)
    //{
    //  printf("%llu\n", p[f]);
    //}
    //printf("\n\n");
    //
    // for each sum
    //
    //printf("n=%d\n", n);
    for(int j = 0;j < n_sums;j++)
    {
      integer_t desired_sum = all_subset_sum_problems[i].sums[j]; // the desired sum
      //printf("%llu\n", desired_sum);
      int b[n]; // array to record the solution
      // for (int l=0; l < n; l++){
      //   b[l]=0;
      // }
      // place your code here
      //   brute_force(n,p,desired_sum,current_index,partial_sum,b);
      //
      int success;
      if (n>=min_n){
        // char stringb[20];
        // sprintf(stringb, "%d", n);
        // fprintf(fpb, "%s ", stringb);
        double time = cpu_time();
        success=horowitz_sahni(n, p, b, desired_sum, 0, 0);
        if (success==1){
          ;
          printf("Solução encontrada, n=%d.\n", n);
        }
        else {
          printf("Solution not found.\n");
          return 0;

        }
        time = cpu_time()-time;
        printf("time needed= %f\n", time);
        // char tempob[50];
        // sprintf(tempob, "%f\n", time);
        // fprintf(fpb, "%s", tempob);
      }
      
     
      // if (n >= min_n){
      //   double time = cpu_time();
      //   if (brute_force(n, p, b, desired_sum, 0, 0)==1){
      //     printf("Solução encontrada, n=%d.\n", n);
      //   }
      //   else {
      //     printf("Solução não encontrada.\n");
      //     return 0;
      //   }
      //   time = cpu_time()-time;
      //   printf("time needed= %f\n", time);
      // }
      

    }
    printf("Not found: %d\n", not_found);
    printf("\n");
    
  }
  // fclose(fpb);
  return 1;
}

// ---------------------------------------------- //