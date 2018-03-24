# TDDTesting

The main target of this repository is learning about TDD, requirements engineering and unit tests
using jUnit 5 and Java SE 8.


### Pitcher Requirements
- Once a pitcher is created, its content will be 0
- Once a pitcher is empty, its content will be 0
- Full refilling a pitcher will make its content will be equals to its
capacity
- Let `a` be the content of the Pitcher `A` and let `b` be the
capacity of the Pitcher `B`. If `a > b` then, if `B` is refilled with `A`
then the content of `B` will be equals to `b` and the content of `A` is equals to `a - b`.
###### Hace farta acabarlo. ^




### Matrix Requirements
- The smallest dimension of a matrix is 1x1.
- When a matrix is created, every element of the matrix is equals to 0
- To add two matrices, both must have same dimensions
- To subtract two matrices, both must have same dimensions
- Let `AxB` be the dimensions of the Matrix `m1` and let `CxD` the dimensions
of another Matrix `m2`, to multiply `m1 * m2` , `B` must be equals to `C` and the
resultant matrix dimension is `AxD`
- Let `c` be a scalar number and `m1` a Matrix. Multiplying `c` with `m1` is equals to
multiply every element in `m1` with `c`. In other words. `∀ x ∈ m1, y = x * c` being y the
elements of the resulting matrix.
- Let `c` be a scalar number and `m1` a Matrix. Dividing `c` with `m1` is equals to
divide every element in `m1` with `c`. In other words. `∀ x ∈ m1, c ≠ 0, y = x / c` being y the
 elements of the resulting matrix.
 - Let `m1` be a Matrix and `m2` its transposed. `m1[x][y] == m2[y][x]` for every x and
 y belonging to `AxB` (`m1` and `m2` dimension).
 - The determinant of a Matrix is calculated with the Sarrus rule (3x3 Matrices), with
 the generic formula (2x2) or just is the element (1x1). (Not sure about my english over here lol)
 