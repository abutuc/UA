//
// AED, November 2021
//
// Solution of the first practical assignement (subset soma problem)
//
// Place your student numbers and names here
// Student 1: André Butuc (nMec: 103530)
// Student 2: Gonçalo Silva (nMec: 103668)

#if __STDC_VERSION__ < 199901L
# error "This code must must be compiled in c99 mode or later (-std=c99)" // to handle the unsigned long long data type
#endif
#ifndef STUDENT_H_FILE
# define STUDENT_H_FILE "000000.h"
#endif

//#define IterativeBruteForce
//#define RecursiveBruteForce
//#define CleverRecursiveBruteForce
//#define HorowitzSahni
#define SchroeppelShamir

#define QuickSort
//#define MergeSort
//
// include files
//

#include <stdio.h>
#include <stdlib.h>
#include "../P02/elapsed_time.h"
#include STUDENT_H_FILE

typedef struct {
   integer_t mascara;
   integer_t soma;
} mascara_struct_t;

typedef struct {
   integer_t mascara;
   integer_t soma;
   int indice0;
   int indice1;
} heapStruct_t;

//
// custom data types
//
// the STUDENT_H_FILE defines the following constants and data types
//
//   #define min_n       24                   --- the smallest n value we will handle
//   #define max_n       57                   --- the largest n value we will handle
//   #define n_sums      20                   --- the number of somas for each n value
//   #define n_problems  (max_n - min_n + 1)  --- the number of n values
//
//   typedef unsigned long long integer_t;    ---  64-bit unsigned integer
//   typedef struct
//   {
//     int n;                                 --- number of elements of the set (for a valid problem, min_n <= n <= max_n)
//     integer_t p[max_n];                    --- the elements of the set, already sorted in increasing order (only the first n elements are used)
//     integer_t somas[n_somas];                --- several sums (problem: for each soma find the corresponding subset)
//   }
//   subset_sum_problem_data_t;               --- weights p[] and sums for a given value of n
//
//   subset_sum_problem_data_t all_subset_sums_problems[n_problems]; --- // the problems
//


//
// place your code here
//
// possible function prototype for a recursive brute-force function:
//   int brute_force(int n,integer_t p[n],integer_t desired_soma,int current_index,integer_t partial_soma,int b[n]);
// it sould return 1 when the solution is found and 0 otherwise
// note, however, that you may get a faster function by reducing the number of function arguments (maybe a single pointer to a struct?)
//

// ---------------------------------------------- //
/*

Seria uma boa ideia colocar este algoritmo no relatório de forma a dar entender ao professor
o nosso algoritmo piloto que nos permitiu estudar o problema e começar a produzir soluções
É possível calcular as somas até n=27.
É também interessante mostrar o gráfico desta solução porque o best-case e o worst-case irão ser bastantes diferentes.
Por exemplo: Para n=28; Best-Case: 1.4 segundos; Worst-Case: > 15 segundos;

*/

int iterative_brute_force(int n, integer_t p[n], integer_t desired_soma)
{ integer_t test_soma;
  for (int comb=0; comb<(1<<n); comb++)
  {
    test_soma=0;
    for (int bit=0; bit<n; bit++)
    {
        if ((comb & (1 << bit)) != 0)
        {
            test_soma += p[bit];
        }
    }
    if (test_soma==desired_soma)
    {
      for (int bit=0; bit<n; bit++)
      {
        if ((comb & (1 << bit)) != 0)       
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

// ---------------------------------------------- //
/*

O algoritmo recursive_brute_force, como o nome indica encontra a soma recursivamente. Em cada valor de p há um "branching": o bit do valor de p fica a 1
ou fica a 0. Em cada ramo, a soma parcial (partial_soma) é incrementada (no ramo do bit igual a 1) ou mantém-se igual (no ramo do bit igual a 0).
De seguida é incrementado o indice do array p e é chamada de novo a função recursive_brute_force.
As condições de paragem da função recursiva são:
  - if(partial_soma == desired_soma), que significa que foi encontrada a solução. Retornando 1 irá desencadear o desenvolvimento das
  sucessivas chamadas prévias da função. Sendo que o bit da folha que desencadeou a terminação da função com sucesso irá ser
  armazenado no array b e assim sucessivamente até à raiz.
  - if(current_index == n), que significa, caso verdadeiro, que a recursividade chegou ao fim do array p e como já não
  há mais elementos ou combinações a somar e como ainda não foi encontrada solução, retorna o valor 0 que por sua vez
  indica que não foi encontrada a solução-soma.
*/

// ---------------------------------------------- //
int recursive_brute_force(int n, integer_t p[n], int b[n], integer_t desired_soma, int current_index, integer_t partial_soma)
{
  if(partial_soma == desired_soma)
    return 1;
  if(current_index == n)
    return 0;
  if (recursive_brute_force(n, p, b, desired_soma, current_index + 1, partial_soma + 0 * p[current_index]) != 0){
    b[current_index]=0;
    return 1;
    }
  if (recursive_brute_force(n, p, b,desired_soma, current_index + 1, partial_soma + 1 * p[current_index]) != 0){
    b[current_index]=1;
    return 1;
    }
  return 0;
}
// ---------------------------------------------- //

// ---------------------------------------------- //
/*

O algoritmo clever_recursive_brute_force, é semelhante ao algoritmo recursive_brute_force, no entanto, apresenta mais 
dois argumentos de entrada que servem calcular uma soma a contar dos últimos indices para os primeiros.
É feita esta soma simultanea de baixo para cima e de cima para baixo do array p para que quando os current_index e current_last_index
se "encontrarem", ou seja, quando forem iguais, podemos avaliar se é possível realmente chegar à soma-solução ou se o nosso array de valores
tem valores demasidado pequenos para alguma vez chegar à soma solução.

As condições de paragem da função recursiva são:
  - if(partial_soma == desired_soma), que significa que foi encontrada a solução. Retornando 1 irá desencadear o desenvolvimento das
  sucessivas chamadas prévias da função. Sendo que o bit da folha que desencadeou a terminação da função com sucesso irá ser
  armazenado no array b e assim sucessivamente até à raiz.
  - if(current_index == n), que significa, caso verdadeiro, que a recursividade chegou ao fim do array p e como já não
  há mais elementos ou combinações a somar e como ainda não foi encontrada solução, retorna o valor 0 que por sua vez
  indica que não foi encontrada a solução-soma.
(Até agora iguais ao algoritmo de recursive_brute_force.)
  - if(partial_soma > desired_soma), a partial_soma já é superior à soma-solução logo nunca irá ser alcançada porque os valores de p
  são todos positivos.
  - if (current_index == current_last_index){
    if (bigger_soma + partial_soma < desired_soma)
  }, este trecho de código avalia se a soma de bigger_soma (soma do fim do array até ao current_last_index) e a soma de
  partial_soma (soma do inicio do array até ao current_index) é inferior a desired_soma. Caso seja, então não há forma possível
  de alguma vez alcançar a soma-solução pois a combinação maior dos elementos de p é inferior à soma-solução.
*/

// ---------------------------------------------- //
int clever_recursive_brute_force(int n, integer_t p[n], int b[n], integer_t desired_soma, int current_index, integer_t partial_soma, int current_last_index, integer_t bigger_soma){
  if(partial_soma > desired_soma)
    return 0;
  
  if(partial_soma == desired_soma)
    return 1;
  
  if(current_index == n)
    return 0;
  
  if (current_index == current_last_index){
    if (bigger_soma + partial_soma < desired_soma){
      return 0;
    }
  }
  if (clever_recursive_brute_force(n, p, b, desired_soma, current_index + 1, partial_soma + 0 * p[current_index], current_last_index - 1, bigger_soma + p[current_last_index]) != 0){
    b[current_index]=0;
    return 1;
    }
  if (clever_recursive_brute_force(n, p, b,desired_soma, current_index + 1, partial_soma + 1 * p[current_index], current_last_index - 1, bigger_soma + p[current_last_index]) != 0){
    b[current_index]=1;
    return 1;
    }
  return 0;
}
// ---------------------------------------------- //

// ---------------------------------------------- //
/*
int swap(mascara_struct_t *a, mascara_struct_t *b)
int partition(mascara_struct_t arr[], int low, int high)
void quicksort(mascara_struct_t arr[], int low, int high)
These three algorithms are used to quicksort a provided array
Quick sort is in best and average case O(nlog(n)), but in the worst case it's O(n^2)
The following three functions were taken/adapted from code/pseudocode from the site GeeksforGeeks -> https://www.geeksforgeeks.org/quick-sort/
We consider that reusing already working and efficient sorting algorithms will reduce the time complexity of the solution.
*/
// ---------------------------------------------- //
void swap(mascara_struct_t *a, mascara_struct_t *b) {
   mascara_struct_t t = *a;
   *a = *b;
   *b = t;
}

int partition(mascara_struct_t arr[], int low, int high) {
   mascara_struct_t pivot = arr[high];
   int i = (low - 1);
   for (int j = low; j <= high - 1; j++) {
      if (arr[j].soma < pivot.soma) {
         i++;
         swap( &arr[i], &arr[j]);
      }
   }
   swap( &arr[i + 1], &arr[high]);
   return (i + 1);
}


void quicksort(mascara_struct_t arr[], int low, int high) {
   if (low < high) {
      int pi = partition(arr, low, high);
      quicksort(arr, low, pi - 1);
      quicksort(arr, pi + 1, high);
   }
}

void insertion_sort(mascara_struct_t *data, int first,int one_after_last)
{
  int i,j;
  for(i = first + 1;i < one_after_last;i++)
  {
    mascara_struct_t tmp = data[i];
    for(j = i; j > first && tmp.soma < data[j - 1].soma;j--){
      data[j] = data[j - 1];
    }
    data[j] = tmp;
  }
}

void merge_sort(mascara_struct_t *data,int first,int one_after_last)
{
  int i,j,k,middle;
  mascara_struct_t *buffer;
  if(one_after_last - first < 40) // do not allocate less than 40 bytes
    insertion_sort(data,first,one_after_last);
  else
  {
    middle = (first + one_after_last) / 2;
    merge_sort(data,first,middle);
    merge_sort(data,middle,one_after_last);
    buffer = (mascara_struct_t *)malloc((size_t)(one_after_last - first) * sizeof(mascara_struct_t)) - first; // no error check!
    i = first; // first input (first half)
    j = middle; // second input (second half)
    k = first; // merged output
    while(k < one_after_last)
      if(j == one_after_last || (i < middle && data[i].soma <= data[j].soma))
        buffer[k++] = data[i++];
      else
        buffer[k++] = data[j++];
    for(i = first;i < one_after_last;i++)
      data[i]= buffer[i];
    free(buffer + first);
  }
}
// ---------------------------------------------- //

/*
void soma_all_subsets(int n, integer_t p[n], mascara_struct_t result[1 << n], int level, integer_t mascara, integer_t subsoma, int idx)

O algoritmo void soma_all_subsets é um algoritmo recursivo que procura encontrar todas as somas possíveis e as correspondentes máscaras 
das somas. Parte do mesmo princípio dos algoritmos recursive_brute_force e clever_recursive_brute_force, no entanto como sabemos que a função terá que percorrer todo
o vetor p, a única condição de paragem é if(current_index == n) que significa que o current_index foi incrementado até ter chegado ao último indice do array p.
No entanto, como sabemos que teremos que guardar todas as "máscaras" das somas, quando a função retorna todas devem ser guardadas.
Devido a este fator desenvolvemos uma estrutura que guarda tanto a soma como a máscara:
typedef struct {
   integer_t mascara;
   integer_t soma;
} mascara_struct_t;

E agora nas sucessivas chamadas recursivas já não é avaliado o valor de retorno, sendo este sempre void, portanto o armazenamento não é feito por indexação
num array que guarda os bits como nos algoritmos anteriores, mas é feito com o auxílio da variável mascara que é representada por bits, que é inicialmente 0.
Em cada chamada recursiva é feita uma operação bit-wise OR do valor da mascara com o valor de 1 bit deslocado para a esquerda de current_index bits, caso 
o bit do elemento de p seja "um".
Vamos supor que temos o valor inicial da mascara 0 e que o elemento que estamos a avaliar tem indice de 5 no vetor p e vamos colocar este elemento com bit 1,
ou seja, participa na soma parcial. Então mascara | (1 << 5) => mascara | 100000 => 000000 | 100000 = 100000  (o valor da mascara é extendido com 0 mais significativos 
até se igual à dimensão com a qual estamos a fazer a operação bit-wise OR, o mesmo acontece inversamente).

Para não haver conflito quando quiseremos guardar elementos no vetor somas (que é o vetor de resultados), quando há o branching do ramo que iguala o bit do elemento a ser 
avaliado a 0 (não participa na soma parcial) é incrementado o indice dos indices impares e o ramo que iguala o bit do elemento a ser avaliado a 1 (participa na soma parcial)
é incrementado o indice dos indices pares.

Quando o indice chega ao final do array p a recursão pára e todos os dados são guardados nos campos da sua estrutura na posição index no vetor soma.

*/

void soma_all_subsets(int n, integer_t p[n], mascara_struct_t somas[1 << n], int current_index, integer_t mascara, integer_t partial_soma, int index){
  if(current_index == n)
  {
    somas[index].soma = partial_soma;
    somas[index].mascara = mascara;
    return;
  }
  soma_all_subsets(n, p, somas, current_index + 1, mascara, partial_soma, 2*index);
  soma_all_subsets(n, p, somas, current_index + 1, mascara | (1 << current_index), partial_soma + p[current_index], 2*index+1);
}

// type == 1 -> min_heap      type == 2 -> max_heap

void push(heapStruct_t h[], heapStruct_t elem, int* h_size, int type)
{
  int i = 0;
  for (i = *h_size; i > 0 && ((h[(i - 1) / 2].soma > elem.soma && type == 1) || (h[(i - 1) / 2].soma < elem.soma && type == 2)); i = (i - 1) / 2)
  {
      h[i] = h[(i - 1) / 2];
  }
  h[i] = elem;
  (*h_size)++;
}

// type == 1 -> min_heap      type == 2 -> max_heap

heapStruct_t pop(heapStruct_t h[], int* h_size, int type)
{
  int i, c;
  heapStruct_t elem = h[0];

  (*h_size)--;
  for (i = 0; i * 2 + 1 <= *h_size; i = c) {
    c = 2 * i + 1;
    if (c < *h_size && ((h[c].soma > h[c + 1].soma && type == 1) || (h[c].soma < h[c + 1].soma && type == 2)))
      c++;
    if ((h[c].soma < h[*h_size].soma && type == 1) || (h[c].soma > h[*h_size].soma && type == 2))
      h[i] = h[c];
    else
      break;
   }
   h[i] = h[*h_size];
   return elem;
}

void minheapInsert(heapStruct_t heap[], heapStruct_t element, int* heapSize)
{
    int i;
    for (i = *heapSize; i > 0 && heap[(i - 1) / 2].soma > element.soma; i = (i - 1) / 2)
    {
        heap[i] = heap[(i - 1) / 2];
    }
    heap[i] = element;
    (*heapSize)++;
}

heapStruct_t deleteMin(heapStruct_t heap[], int* heapSize)
{
   int i, son;
   heapStruct_t element = heap[0];

   (*heapSize)--;
   for (i = 0; i * 2 + 1 <= *heapSize; i = son) {
      son = 2 * i + 1;
      if (son < *heapSize && heap[son].soma > heap[son + 1].soma)
         son++;
      if (heap[son].soma < heap[*heapSize].soma)
         heap[i] = heap[son];
      else
         break;
   }

   heap[i] = heap[*heapSize];
   return element;
}

void maxheapInsert(heapStruct_t heap[], heapStruct_t element, int* heapSize)
{
   int i;
   for (i = *heapSize; i > 0 && heap[(i - 1) / 2].soma < element.soma; i = (i - 1) / 2) {
      heap[i] = heap[(i - 1) / 2];
   }
   heap[i] = element;
   (*heapSize)++;
}

heapStruct_t deletemax(heapStruct_t heap[], int* heapSize)
{
   int i, son;
   heapStruct_t element = heap[0];

   (*heapSize)--;
   for (i = 0; i * 2 + 1 <= *heapSize; i = son) {
      son = 2 * i + 1;
      if (son < *heapSize && heap[son].soma < heap[son + 1].soma)
         son++;
      if (heap[son].soma > heap[*heapSize].soma)
         heap[i] = heap[son];
      else
         break;
   }
   heap[i] = heap[*heapSize];
   return element;
}
// ---------------------------------------------- //

// ---------------------------------------------- //

int horowitz_sahni(int n, integer_t p[n], integer_t *solucao_mascara, integer_t desired_sum, int current_index, integer_t partial_soma){
  int n1 = n/2;
  int n2 = n - n1;
  integer_t p1[n1];
  integer_t p2[n2];
  int length_a = 1 << n1;
  int length_c = 1 << n2;
  mascara_struct_t *a = malloc(length_a * sizeof(mascara_struct_t));
  mascara_struct_t *c = malloc(length_c * sizeof(mascara_struct_t));

  for (int i=0; i<n; i++){
    if (i < n/2){
      p1[i] = p[i];
    }
    else {
      p2[i - (n/2)] = p[i];
    }
  }

  soma_all_subsets(n1, p1, a, 0, 0, 0, 0);
  soma_all_subsets(n2, p2, c, 0, 0, 0, 0);

  #ifdef MergeSort
  merge_sort(a, 0, length_a);
  merge_sort(c, 0, length_c);
  #endif

  #ifdef QuickSort
  quicksort(a, 0, length_a-1);
  quicksort(c, 0, length_c-1);
  #endif
  
  int indice_a = 0;
  int indice_c = length_c - 1;
  integer_t soma = 0;
  integer_t solucao = 0;
  int ret = 0;

  while (indice_a < length_a && indice_c >= 0) {
    soma = a[indice_a].soma + c[indice_c].soma;
    if (soma == desired_sum) {
        solucao = a[indice_a].mascara | (c[indice_c].mascara << length_a);
        ret = 1;
        break;
    }
    if (soma < desired_sum) {
        indice_a++;
    }
    if (soma > desired_sum){
        indice_c--;
    }
  }

  *solucao_mascara = solucao;
  free(a);
  free(c);
  return ret;
}

// ---------------------------------------------- //

// ---------------------------------------------- //
int schroeppel_shamir (int n, integer_t p[], integer_t desired_soma, integer_t * solucao_mascara) {

  int n1 = n/4 + (n%4)/2;
  int n2 = n/4;
  int n3 = n/4 + (n%4)/2;
  int n4 = n-n1-n2-n3;

  integer_t p1[n];
  integer_t p2[n2];
  integer_t p3[n3];
  integer_t p4[n4]; 

  for (int i=0; i<n; i++){
    if (i < n1){
      p1[i] = p[i];
    }
    else if (i < n1+n2){
      p2[i - n1] = p[i];
    }
    else if (i < n1+n2+n3){
      p3[i - n1 - n2] = p[i];
    }
    else {
      p4[i - n1 - n2 - n3] = p[i];
    }
  }

  int length_a1 = 1 << n1;
  int length_a2 = 1 << n2;
  int length_b1 = 1 << n3;
  int length_b2 = 1 << n4;

  mascara_struct_t * a1 = malloc((length_a1) * sizeof(mascara_struct_t));
  mascara_struct_t * a2 = malloc((length_a2) * sizeof(mascara_struct_t));
  mascara_struct_t * b1 = malloc((length_b1) * sizeof(mascara_struct_t));
  mascara_struct_t * b2 = malloc((length_b2) * sizeof(mascara_struct_t));

  soma_all_subsets(n1, p1, a1, 0, 0, 0, 0);
  soma_all_subsets(n2, p2, a2, 0, 0, 0, 0);
  soma_all_subsets(n3, p3, b1, 0, 0, 0, 0);
  soma_all_subsets(n4, p4, b2, 0, 0, 0, 0);


  #ifdef MergeSort
  merge_sort(a1, 0, length_a1);
  merge_sort(a2, 0, length_a2);
  merge_sort(b1, 0, length_b1);
  merge_sort(b2, 0, length_b2);
  #endif

  #ifdef QuickSort
  quicksort(a1, 0, length_a1 - 1);
  quicksort(a2, 0, length_a2 - 1);
  quicksort(b1, 0, length_b1 - 1);
  quicksort(b2, 0, length_b2 - 1);
  #endif
  
  heapStruct_t min_heap[length_a1];
  int n_min_heap = 0;

  heapStruct_t max_heap[length_b1]; 
  int n_max_heap = 0;

  for (int i = 0; i < length_a1; i++) {
    heapStruct_t soma = {
        .mascara = a1[i].mascara | (a2[0].mascara << n1),
        .soma = a1[i].soma + a2[0].soma,
        .indice0 = i,
        .indice1 = 0
    };
    minheapInsert(min_heap, soma, &n_min_heap);
   }

  for (int i = 0; i < length_b1; i++) {
    heapStruct_t soma = {
        .mascara = b1[i].mascara | (b2[length_b2 - 1].mascara << n3),
        .soma = b1[i].soma + b2[length_b2- 1].soma,
        .indice0 = i,
        .indice1 = length_b2 - 1
    };
    maxheapInsert(max_heap,soma,&n_max_heap);
   }

  int ret = 0;
  integer_t solucao = 0;
  
  
  while (n_max_heap > 0 && n_min_heap > 0){
    integer_t partial_soma = min_heap[0].soma+ max_heap[0].soma;
    if (partial_soma ==  desired_soma) {
        solucao = min_heap[0].mascara | (max_heap[0].mascara << (n1+n2));
        ret = 1;
        break;
    }

    if (partial_soma < desired_soma){
        heapStruct_t vmin = deleteMin(min_heap, &n_min_heap);
        vmin.indice1++;
        if (vmin.indice1 < length_a2) {
          heapStruct_t w = {
              .mascara = a1[vmin.indice0].mascara | (a2[vmin.indice1].mascara << n1),
              .soma = a1[vmin.indice0].soma + a2[vmin.indice1].soma,
              .indice0 = vmin.indice0,
              .indice1 = vmin.indice1
          };
          minheapInsert(min_heap, w, &n_min_heap);
         }
      }

    if (partial_soma > desired_soma){
        heapStruct_t vmax = deletemax(max_heap,&n_max_heap);
        vmax.indice1--;

        if (vmax.indice1 >= 0) {
          heapStruct_t w = {
              .mascara = b1[vmax.indice0].mascara | (b1[vmax.indice1].mascara << n3),
              .soma = b1[vmax.indice0].soma + b2[vmax.indice1].soma,
              .indice0 = vmax.indice0,
              .indice1 = vmax.indice1
          };
          maxheapInsert(max_heap,w,&n_max_heap);
        }
    }
  }

  *solucao_mascara = solucao;
  free(a1);
  free(a2);
  free(b1);
  free(b2);
  return ret;
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
  fprintf(stderr,"  n_somas ...... %d\n",n_sums);
  fprintf(stderr,"  n_problems .. %d\n",n_problems);
  fprintf(stderr,"  integer_t ... %d bits\n",8 * (int)sizeof(integer_t));
  //
  // for each n
  //
  // FILE *fpb = NULL;
  // fpb = fopen("clever_brute_force_data.txt", "w");
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
    // for each soma
    //
    //printf("n=%d\n", n);
    for(int j = 0;j < n_sums;j++)
    {
      integer_t desired_soma = all_subset_sum_problems[i].sums[j]; // the desired soma
      //printf("%llu\n", desired_soma);
      integer_t b[n]; // array to record the solution
      // for (int l=0; l < n; l++){
      //   b[l]=0;
      // }
      // place your code here
      //   brute_force(n,p,desired_soma,current_index,partial_soma,b);
      //
      int success;
      if (n>=min_n){
        // char stringb[20];
        // sprintf(stringb, "%d", n);
        // fprintf(fpb, "%s ", stringb);
        double time = cpu_time();
        #ifdef IterativeBruteForce
          success=iterative_brute_force(n, p, desired_soma);
        #endif

        #ifdef RecursiveBruteForce
          success=recursive_brute_force(n, p, b, desired_soma, 0, 0);
        #endif

        #ifdef CleverRecursiveBruteForce
          success=clever_recursive_brute_force(n, p, b, desired_soma, 0, 0, n-1, 0);
        #endif

        #ifdef HorowitzSahni
          success=horowitz_sahni(n, p, b, desired_soma, 0, 0);
        #endif

        #ifdef SchroeppelShamir
          success=schroeppel_shamir(n, p, desired_soma, b);
        #endif
        
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
    }
    printf("\n");
    
  }
  // fclose(fpb);
  return 1;
}

// ---------------------------------------------- //