/* File : example.c */

#include <stdio.h>
#include "example.h"



/* A global variable */
double Foo = 3.0;

struct Vector vec;

/* Compute the greatest common divisor of positive integers */
int gcd(int x, int y) {
printf("inside gcd %d\n",x);
  int g;
  g = y;
  while (x > 0) {
    g = x;
    x = y % x;
    y = g;
  }
  return g;
}

void printVal(){

int fo=Foo/1;
printf ("foo val : %d\n",fo);
int a=2;
//vec.x=10;

printf("vec val test : %d, aval : %d\n",vec.x,a);
}


