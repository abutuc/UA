// AED, January 2022
//
// Solution of the second practical assignement (multi-ordered tree)
//
// Place your student numbers and names here
// André Butuc-103530
// Gonçalo Silva-103668
// João Matos-103182

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include "AED_2021_A02.h"

// the custom tree node structure
//
// we want to maintain three ordered trees (using the same nodes!), so we need three left and three right pointers
// so, when inserting a new node we need to do it three times (one for each index), so we will end upo with 3 three roots

typedef struct tree_node_s
{
  char name[MAX_NAME_SIZE + 1];                         // index 0 data item
  char zip_code[MAX_ZIP_CODE_SIZE + 1];                 // index 1 data item
  char telephone_number[MAX_TELEPHONE_NUMBER_SIZE + 1]; // index 2 data item
  char social_security[MAX_SOCIAL_SECURITY_SIZE + 1];   // index 3 data item
  struct tree_node_s *left[4];                          // left pointers (one for each index) ---- left means smaller
  struct tree_node_s *right[4];                         // right pointers (one for each index) --- right means larger
} tree_node_t;

//
// the node comparison function (do not change this)
//

int compare_tree_nodes(tree_node_t *node1, tree_node_t *node2, int main_idx)
{
  int i, c;

  for (i = 0; i < 4; i++)
  {
    if (main_idx == 0)
      c = strcmp(node1->name, node2->name);
    else if (main_idx == 1)
      c = strcmp(node1->zip_code, node2->zip_code);
    else if (main_idx == 2)
      c = strcmp(node1->telephone_number, node2->telephone_number);
    else
      c = strcmp(node1->social_security, node2->social_security);
    if (c != 0)
      return c;                                    // different on this index, so return
    main_idx = (main_idx == 3) ? 0 : main_idx + 1; // advance to the next index
  }
  return 0;
}

//
// tree insertion routine (place your code here)
//

void tree_insert(tree_node_t **rootptr, tree_node_t *node_data, int idx) // idx= index--main_index
{
  if (rootptr[idx] == NULL)
  {
    rootptr[idx] = node_data;
    return;
  }
  else if (compare_tree_nodes(node_data, rootptr[idx], idx) < 0)
  {
    tree_insert(rootptr[idx]->left, node_data, idx);
  }
  else if (compare_tree_nodes(node_data, rootptr[idx], idx) > 0)
  {
    tree_insert(rootptr[idx]->right, node_data, idx);
  }
  return;
  //  node1/node2 são argumentos de passagem da função compare_tree_nodes
  //  compare_tree_nodes pode returnar 0 (conteudo do node1 já está na tree), um valor <0 (conteudo de node1 tem um codigo ASCII mais "pequeno" que o do node2,
  //  logo descemos na arvore para a esquerda do node2) eum valor >0 (conteudo de node1 tem um codigo ASCII "maior" que o do node2, logo descemos na arvore para
  //  a direita do node2)
}
//
// tree search routine (place your code here)
//

tree_node_t *find(tree_node_t **link, tree_node_t n, int idx)
{
  if (link[idx] == NULL || compare_tree_nodes(&n, link[idx], idx) == 0)
  {
    return link[idx];
  }
  if (compare_tree_nodes(&n, link[idx], idx) > 0)
  {
    return find(link[idx]->right, n, idx);
  }
  else
  {
    return find(link[idx]->left, n, idx);
  }
}

//
// tree depth
//
// tree depth= height+1
int tree_depth(tree_node_t **rootptr, int idx)
{
  if (rootptr[idx] == NULL)
  {
    // arvore não existe
    return 0;
  }
  int left_depth = tree_depth(rootptr[idx]->left, idx);
  int right_depth = tree_depth(rootptr[idx]->right, idx);

  if (left_depth > right_depth)
  {
    return left_depth + 1;
  }
  else
  {
    return right_depth + 1;
  }
}

void print_info(tree_node_t **link, int *cont, int idx)
{
  *cont = *cont + 1;
  printf("Person #%d\n", *cont);
  printf("\tname= %s\n", link[idx]->name);
  printf("\tzip_code= %s\n", link[idx]->zip_code);
  printf("\ttelephone_number= %s\n", link[idx]->telephone_number);
  printf("\tSecurity Social number= %s\n", link[idx]->social_security);
}
//  list, i,e, traverse the tree (place your code here)
//
void list(tree_node_t **link, int idx, int *cont, int val, char *str)
{

  if (link[idx] != NULL)
  {
    if (link[idx]->left)
    {
      list(link[idx]->left, idx, cont, val, str);
    }

    if (val >= 0)
    {
      if (val == 0)
      {
        if (strcmp(str, link[idx]->name) == 0)
        {
          print_info(link, cont, idx);
        }
      }
      if (val == 1)
      {
        if (strcmp(str, link[idx]->zip_code) == 0)
        {
          print_info(link, cont, idx);
        }
      }
      if (val == 2)
      {
        if (strcmp(str, link[idx]->telephone_number) == 0)
        {
          print_info(link, cont, idx);
        }
      }
      if (val == 3)
      {
        if (strcmp(str, link[idx]->social_security) == 0)
        {
          print_info(link, cont, idx);
        }
      }
    }
    else
    {
      print_info(link, cont, idx);
    }

    if (link[idx]->right)
    {
      list(link[idx]->right, idx, cont, val, str);
    }
  }
}

int count_nodes(tree_node_t **roots, int current_level, int level, int main_index)
{
  if (roots[main_index] == NULL)
    return 0;
  if (current_level == level)
    return 1;

  return count_nodes(roots[main_index]->left, current_level + 1, level, main_index) + count_nodes(roots[main_index]->right, current_level + 1, level, main_index);
}

int validate(char *str)
{

  if (isalpha(str[0]))
  {
    // printf("nome\n");
    return 0; // codigo-->name
  }
  else if (str[5] == ' ')
  {
    // printf("zip code\n");
    return 1; // codigo-->zip code
  }
  else if (str[4] == ' ')
  {
    // printf("telephone\n");
    return 2; // codigo-->telephone
  }
  else if (str[3] == ' ')
  {
    // printf("social security\n");
    return 3; // codigo-->social security
  }
  return -1;
}

//
// main program
//

int main(int argc, char **argv)
{
  double dt;

  // process the command line arguments
  if (argc < 3)
  {
    fprintf(stderr, "Usage: %s student_number number_of_persons [options ...]\n", argv[0]);
    fprintf(stderr, "Recognized options:\n");
    fprintf(stderr, "  -list[N]              # list the tree contents, sorted by key index N (the default is index 0)\n");
    // place a description of your own options here
    return 1;
  }
  

  int student_number = 1;
  if (student_number < 1 || student_number >= 1000000)
  {
    fprintf(stderr, "Bad student number (%d) --- must be an integer belonging to [1,1000000]\n", student_number);
    return 1;
  }


  int n_persons = 10000000;
  
  if (n_persons < 3 || n_persons > 10000000)
  {
    fprintf(stderr, "Bad number of persons (%d) --- must be an integer belonging to [3,10000000]\n", n_persons);
    return 1;
  }
  tree_node_t *persons = (tree_node_t *)calloc((size_t)n_persons, sizeof(tree_node_t));
  if (persons == NULL)
  {
    fprintf(stderr, "Output memory!\n");
    return 1;
  }
  aed_srandom(student_number);
  for (int i = 0; i < n_persons; i++)
  {
    random_name(&(persons[i].name[0]));
    random_zip_code(&(persons[i].zip_code[0]));
    random_telephone_number(&(persons[i].telephone_number[0]));
    random_social_security(&(persons[i].social_security[0]));

    for (int j = 0; j < 3; j++)
      persons[i].left[j] = persons[i].right[j] = NULL; // make sure the pointers are initially NULL
  }
  // create the ordered binary trees
  dt = cpu_time();
  tree_node_t *roots[4]; // four indices, four roots
  for (int main_index = 0; main_index < 4; main_index++)
    roots[main_index] = NULL;
  for (int i = 0; i < n_persons; i++)
    for (int main_index = 0; main_index < 4; main_index++)
      tree_insert(roots, &(persons[i]), main_index); // place your code here to insert &(persons[i]) in the tree with number main_index

  // completar AQUI

  dt = cpu_time() - dt;
  printf("Tree creation time (%d persons): %.3es\n", n_persons, dt);
  //fprintf(fcreation, "%d  %.3e\n",n_persons,dt);
  // search the tree
  // for (int main_index = 0; main_index < 4; main_index++)
  // {
  //   dt = cpu_time();
  //   for (int i = 0; i < n_persons; i++)
  //   {
  //     tree_node_t n = persons[i];                      // make a copy of the node data
  //     if (find(roots, n, main_index) != &(persons[i])) // place your code here to find a given person, searching for it using the tree with number main_index
  //     {
  //       fprintf(stderr, "person %d not found using index %d\n", i, main_index);
  //       return 1;
  //     }
  //   }
  //   dt = cpu_time() - dt;
  //   //fprintf(fsearch, "%d  %d  %.3e\n",n_persons, main_index, dt);
  //   printf("Tree search time (%d persons, index %d): %.3es\n", n_persons, main_index, dt);
  // }
  // compute the largest tree depdth
  // for (int main_index = 0; main_index < 4; main_index++)
  // {
  //   dt = cpu_time();
  //   int depth = tree_depth(roots, main_index); // place your code here to compute the depth of the tree with number main_index
  //   dt = cpu_time() - dt;
  //   printf("Tree depth for index %d: %d (done in %.3es)\n", main_index, depth, dt);
  //   //fprintf(fdepth, "%d  %d  %d  %.3e\n",n_persons, main_index, depth,dt);
  // }
  // process the command line optional arguments
  int main_index = 0;
  char str[50];
  int val = -2;
  int cont = 0;
  for (int i = 3; i < argc; i++)
  {
    if (strncmp(argv[i], "-list", 5) == 0)
    { // list all (optional)
      main_index = atoi(&(argv[i][5]));
      if (main_index < 0)
        main_index = 0;
      if (main_index >= 3)
        main_index = 3;
    }
    // place your own options here
    if (strncmp(argv[i], "-select", 7) == 0)
    {
      strcpy(str, argv[i + 1]);
      val = validate(str);
      if (val == -1)
      {
        printf("String de pesquisa com formato inválido\n");
        exit(1);
      }
    }
  }

  printf("List of persons:\n");
  dt = cpu_time();
  (void)list(roots, main_index, &cont, val, str); // place your code here to traverse, in order, the tree with number main_index
  dt = cpu_time() - dt;
  printf("%.3e\n", dt);
  if (cont == 0)
  {
    printf("No match found\n");
  }
  int level, current_level, n_nodes;

  current_level = 0;

  FILE *f = fopen("nodes.txt", "w");
  for (int main_index = 0; main_index < 1; main_index++)
  {
    n_nodes = 0;
    level = 0;
    int depth = tree_depth(roots, main_index);
    if (main_index == 0)
      printf("name_tree");
    if (main_index == 1)
      printf("zip_code_tree");
    if (main_index == 2)
      printf("telephone_tree");
    if (main_index == 3)
      printf("social_security_tree");

    for (int i = 0; i < depth; i++)
    {
      n_nodes = count_nodes(roots, current_level, level, main_index);
      fprintf(f, "%d  %d\n", level, n_nodes);
      level++;
    }
  }
  fclose(f);

  // clean up --- don't forget to test your program with valgrind, we don't want any memory leaks
  free(persons);
  return 0;
}
