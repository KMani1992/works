/* File : example.i */
%module example

%inline %{
extern int    gcd(int x, int y);
extern double Foo;
extern void printVal();
#include <stdlib.h>
#include "example.h";
extern struct Vector vec;
%}
%include "example.h";
