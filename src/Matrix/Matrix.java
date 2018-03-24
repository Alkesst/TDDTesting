package Matrix;

public class Matrix {
    private int matrix[][];
    private int rows;
    private int columns;

    public Matrix(int rows, int columns){
        this.columns = columns;
        this.rows = rows;
        this.matrix = new int[columns][rows];
        for(int i = 0; i < columns; i++){
            matrix[i] = new int[rows];
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getElement(int row, int column){
        isOutOfBounds(row, column);
        return matrix[column][row];
    }

    public void setElement(int row, int column, int element){
        isOutOfBounds(row, column);
        matrix[column][row] = element;
    }

    private void isOutOfBounds(int row, int column) {
        if (row > this.rows || column > this.columns)
            throw new MatrixException("Matrix Out Of Bounds");
    }

    public Matrix add(Matrix m) throws MatrixException{
        if (this.columns != m.columns || this.rows != m.rows)
            throw new MatrixException("Incompatible matrices.");
        Matrix result = new Matrix(m.rows, m.columns);
        for(int i = 0; i < m.rows; i++){
            for(int j = 0; j < m.columns; j++){
                result.setElement(i, j, this.getElement(i, j) + m.getElement(i, j));
            }
        }
        return result;
    }

    public Matrix subtract(Matrix m) throws MatrixException{
        if (this.columns != m.columns ||this.rows != m.rows)
            throw new MatrixException("Incompatible matrices.");
        Matrix result = new Matrix(m.rows, m.columns);
        for(int i = 0; i < m.rows; i++){
            for(int j = 0; j < m.columns; j++){
                result.setElement(i, j, this.getElement(i, j) - m.getElement(i, j));
            }
        }
        return result;
    }

    public Matrix scalarMultiplication(int scalar){
        Matrix result = new Matrix (this.getRows(), this.getColumns());
        for(int i = 0; i < this.getRows(); i++){
            for(int j = 0; j < this.getColumns(); j++){
                result.setElement(i, j, scalar * this.getElement(i, j));
            }
        }
        return result;
    }

    public Matrix scalarDivision(int scalar){
        if (scalar == 0)
            throw new MatrixException("Scalar division by 0");
        Matrix result = new Matrix(this.getRows(), this.getColumns());
        for(int i = 0; i < this.getRows(); i++){
            for(int j = 0; j < this.getColumns(); j++){
                result.setElement(i, j, this.getElement(i, j) / scalar);
            }
        }
        return result;
    }

    public Matrix multiplication(Matrix matrix){
        if (this.getColumns() != matrix.getRows())
            throw new MatrixException("Incompatible matrices.");
        Matrix result = new Matrix(this.getRows(), matrix.getColumns());
        for(int i = 0; i < this.getRows(); i++){
            for(int j = 0; j < this.getColumns(); j++){
                result.setElement(i, j, getIntermediateSummatory(i, j, matrix));
            }
        }
        return result;
    }

    protected int getIntermediateSummatory(int i, int j, Matrix matrix){
        int result = 0;
        for (int r = 0; r < matrix.getRows(); r++){
            result += this.getElement(i, r) * matrix.getElement(j, r);
        }
        return result;
    }
}
