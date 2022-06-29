#include "first.h"

int CallAdd(int a, int b)
{
  return a + b;
}

int CallBuf(unsigned char *srcbuf, unsigned long srclen, unsigned char *dstbuf)
{
  int i = 0;
  if (srcbuf == 0 || srclen == 0 || dstbuf == 0)
  {
    return -1;
  }
  for (i = 0; i < srclen; i++)
  {
    *(dstbuf + i) = *(srcbuf + i) + 1;
  } 
  return 0;
}
