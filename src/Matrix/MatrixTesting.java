package Matrix;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class MatrixTesting {
    private static int DETERMINANT_RESULT = -2;
    private static int DETERMINANT_RESULT_3x3 = 0;
    private static int DETERMINANT_RESULT_4x4 = 0;

    @Test
    @DisplayName("Matrix Constructor test")
    void testMatrixConstructor(){
        Matrix matrix = new Matrix(2, 3);
        for(int i = 0; i < matrix.getRows(); i++){
            for(int j = 0; j < matrix.getColumns(); j++){
                assertEquals(0, matrix.getElement(i, j));
            }
        }
    }

    @Test
    @DisplayName("Test Set Element and Get Element")
    void testSetElement(){
        Matrix matrix = new Matrix(2, 3);
        matrix.setElement(1, 2, 3);
        assertEquals(3, matrix.getElement(1, 2));
    }

    @Test
    @DisplayName("Matrix Out of bounds Get")
    void testOutOfBoundsGetElement(){
        Matrix matrix = new Matrix(8, 7);
        assertThrows(
                MatrixException.class,
                () -> matrix.getElement(200, 200)
        );
    }

    @Test
    @DisplayName("Matrix Out Of Bounds Set")
    void testOutOfBoundsSetElement(){
        Matrix matrix = new Matrix(7, 7);
        assertThrows(
                MatrixException.class,
                () -> matrix.setElement(200, 200, 10)
        );
    }

    @Test
    @DisplayName("Adding Non-compatible Matrix Test")
    void testExceptionAdd(){
        Matrix m1 = new Matrix(2, 4);
        Matrix m2 = new Matrix(4, 2);
        assertThrows(
                MatrixException.class,
                () -> m1.add(m2)
        );
    }

    @Test
    @DisplayName("Adding two compatible Matrix Test")
    void testCompatibleSum(){
        Matrix m1 = new Matrix(2, 2);
        Matrix m2 = new Matrix(2, 2);
        for(int i = 0; i < m1.getRows(); i++){
            for(int j = 0; j < m1.getColumns(); j++){
                m1.setElement(i, j, i + j);
                m2.setElement(i, j, i + j);
            }
        }
        Matrix m3 = m1.add(m2);
        for(int i = 0; i < m1.getRows(); i++){
            for(int j = 0; j < m1.getColumns(); j++){
                assertEquals(2 * (i + j), m3.getElement(i, j));
            }
        }
    }

    @Test
    @DisplayName("Subtract compatible matrix test")
    void testSubtractingTwoCompatibleMatrix(){
        Matrix m1 = new Matrix(3, 4);
        Matrix m2 = new Matrix(3, 4);
        for(int i = 0; i < m1.getRows(); i++){
            for(int j = 0; j < m1.getColumns(); j++){
                m1.setElement(i, j, i + j);
                m2.setElement(i, j, (i + j));
            }
        }
        Matrix m3 = m2.subtract(m1);
        for(int i = 0; i < m1.getRows(); i++){
            for(int j = 0; j < m1.getColumns(); j++){
                assertEquals(0, m3.getElement(i, j));
            }
        }
    }

    @Test
    @DisplayName("Subtract non-compatible matrix test")
    void testSubtractingTwoNonCompatibleMatrix(){
        Matrix m1 = new Matrix(3, 4);
        Matrix m2 = new Matrix(4, 3);
        assertThrows(
                MatrixException.class,
                () -> m1.subtract(m2)
        );
    }

    @Test
    @DisplayName("Scalar Multiplication Test")
    void testScalarMultiplication(){
        Matrix m1 = new Matrix(8, 8);
        for(int i = 0; i < m1.getRows(); i++){
            for(int j = 0; j < m1.getColumns(); j++){
                m1.setElement(i, j, i + j);
            }
        }
        Matrix m2 = m1.scalarMultiplication(5);
        for(int i = 0; i < m1.getRows(); i++){
            for(int j = 0; j < m1.getColumns(); j++){
                assertEquals(5 * (i + j), m2.getElement(i, j));
            }
        }
    }

    @Test
    @DisplayName("Scalar Division test")
    void testScalarDivision(){
        Matrix m1 = new Matrix(8, 8);
        for(int i = 0; i < m1.getRows(); i++){
            for(int j = 0; j < m1.getColumns(); j++){
                m1.setElement(i, j, i + j);
            }
        }
        Matrix m2 = m1.scalarDivision(3);
        for(int i = 0; i < m1.getRows(); i++){
            for(int j = 0; j < m1.getColumns(); j++){
                assertEquals((i + j) / 3, m2.getElement(i, j));
            }
        }
    }

    @Test
    @DisplayName("Scalar Division Exception test")
    void testScalarDivisionBy0Exception(){
        Matrix m = new Matrix(5, 10);
        assertThrows(
                MatrixException.class,
                () -> m.scalarDivision(0)
        );
    }

    /*
     * Here is where the party begins!!
     */

    @Test
    @DisplayName("Incompatible Matrix Multiplication Test")
    void testIncompatibleMatrixMultiplication(){
        Matrix m1 = new Matrix(2, 3);
        Matrix m2 = new Matrix(4, 3);
        assertThrows(
          MatrixException.class,
                () -> m1.multiplication(m2)
        );
    }

    @Test
    @DisplayName("Compatible Matrix Multiplication Test")
    void testCompatibleMatrixMultiplication(){
        Matrix m1 = new Matrix(2, 3);
        Matrix m2 = new Matrix(3, 4);
        for(int i = 0; i < m1.getRows(); i++){
            for(int j = 0; j < m1.getColumns(); j++){
                m1.setElement(i, j, i + j);
            }
        }
        Matrix m3 = m1.multiplication(m2);
        assertEquals(m1.getRows(), m3.getRows());
        assertEquals(m2.getColumns(), m3.getColumns());
        for(int i = 0; i < m1.getRows(); i++){
            for(int j = 0; j < m1.getColumns(); j++){
                assertEquals(m1.getIntermediateSummatory(i, j, m2), m2.getElement(i, j));
            }
        }

    }

    /*
     * Party v2.
     */

    @Test
    @DisplayName("Transposition Matrix Test")
    void testTranspositionMatrix(){
        Matrix matrix = new Matrix(5, 3);
        for(int i = 0; i < matrix.getRows(); i++){
            for(int j = 0; j < matrix.getColumns(); j++){
                matrix.setElement(i, j, (i + j) / 2);
            }
        }
        Matrix m2 = matrix.transposition();
        assertEquals(matrix.getColumns(), m2.getRows());
        assertEquals(matrix.getRows(), m2.getColumns());
        for(int i = 0; i < matrix.getRows(); i++){
            for(int j = 0; j < matrix.getColumns(); j++){
                assertEquals(matrix.getElement(i, j), m2.getElement(j, i));
            }
        }
    }

    @Test
    @DisplayName("Determinant 1x1 Matrix Test")
    void testDeterminant1x1Matrix(){
        Matrix matrix = new Matrix(1, 1);
        matrix.setElement(0, 0, -2);
        int determinant = matrix.determinant();
        assertEquals(DETERMINANT_RESULT, determinant);
    }


    @Test
    @DisplayName("Determinant 2x2 Matrix Test")
    void testDeterminant2x2Matrix(){
        Matrix matrix = new Matrix(2, 2);
        matrix.setElement(0, 0, 1);
        matrix.setElement(0, 1, 2);
        matrix.setElement(1, 0, 3);
        matrix.setElement(1, 1, 4);
        int determinant = matrix.determinant();
        assertEquals(DETERMINANT_RESULT, determinant);
    }

    @Test
    @DisplayName("Determinant 3x3 Matrix Test")
    void testDeterminant3x3Matrix(){
        Matrix matrix = new Matrix(3, 3);
        for (int i = 0; i < matrix.getRows(); i++){
            for (int j = 0; j < matrix.getColumns(); j++){
                matrix.setElement(i, j, i + j);
            }
        }
        assertEquals(DETERMINANT_RESULT_3x3, matrix.determinant());
    }

    @Test
    @DisplayName("Determinant 4x4 Matrix Test")
    void testDeterminant4x4Matrix(){

    }

    @Test
    @DisplayName("Determinant Matrix Exception Test")
    void testDeterminantExceptionTest(){
        Matrix matrix = new Matrix(4, 5);
        assertThrows(
          MatrixException.class,
                matrix::determinant
        );
    }
/*
    @Test
    @DisplayName("Adjunct Matrix Test")
    void testAdjunctMatrix(){
        Matrix matrix = new Matrix(3, 3);
        for (int i = 0; i < matrix.getRows(); i++){
            for (int j = 0; j < matrix.getColumns(); j++){
                matrix.setElement(i, j, i + j);
            }
        }

    }

    @Test
    @DisplayName("Adjunct Matrix Exception Test")
    void testAdjunctMatrixException(){
        Matrix matrix = new Matrix(3, 4);
        assertThrows(
                MatrixException.class,
                matrix::adjunct
        );
    }
*/
}
