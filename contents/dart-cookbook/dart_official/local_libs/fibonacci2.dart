int fibonacci2(int n) {
  if (n == 0 || n == 1) return n;
  return fibonacci2(n - 1) + fibonacci2(n - 2);
}
