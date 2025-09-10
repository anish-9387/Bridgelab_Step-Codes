public class MatrixOperations{
    // Method to create a random matrix
    public int[][] generateMatrix(int rows, int cols){
        int[][] matrix = new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                matrix[i][j] = (int)(Math.random() * 10);
			}
		}
        return matrix;
    }

    // Method to add two matrices
    public int[][] addMatrices(int[][] a, int[][] b){
        int[][] result = new int[a.length][a[0].length];
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[0].length; j++){
                result[i][j] = a[i][j] + b[i][j];
			}
		}
        return result;
    }

    // Method to subtract two matrices
    public int[][] subtractMatrices(int[][] a, int[][] b){
        int[][] result = new int[a.length][a[0].length];
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[0].length; j++){
                result[i][j] = a[i][j] - b[i][j];
			}
		}
        return result;
    }

    // Method to multiply two matrices
    public int[][] multiplyMatrices(int[][] a, int[][] b){
        int rows = a.length, cols = b[0].length, sumLen = a[0].length;
        int[][] result = new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                for(int k=0; k<sumLen; k++){
                    result[i][j] += a[i][k] * b[k][j];
				}
			}
		}
        return result;
    }

    // Method to transpose a matrix
    public int[][] transposeMatrix(int[][] matrix){
        int rows = matrix.length, cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                result[j][i] = matrix[i][j];
			}
		}
        return result;
    }

    // Method to find the determinant of 2x2 matrix
    public int determinant2x2(int[][] m){
        return m[0][0]*m[1][1] - m[0][1]*m[1][0];
    }

    // Method to find the determinant of 3x3 matrix
    public int determinant3x3(int[][] m){
        return m[0][0]*(m[1][1]*m[2][2] - m[1][2]*m[2][1])
             - m[0][1]*(m[1][0]*m[2][2] - m[1][2]*m[2][0])
             + m[0][2]*(m[1][0]*m[2][1] - m[1][1]*m[2][0]);
    }

    // Method to find the inverse of 2x2 matrix
    public double[][] inverse2x2(int[][] m){
        int det = determinant2x2(m);
        if(det == 0)  return null;
        double[][] inv = new double[2][2];
        inv[0][0] = m[1][1] / (double)det;
        inv[0][1] = -m[0][1] / (double)det;
        inv[1][0] = -m[1][0] / (double)det;
        inv[1][1] = m[0][0] / (double)det;
        return inv;
    }

    // Method to find the inverse of 3x3 matrix using adjoint and determinant
    public double[][] inverse3x3(int[][] m){
        int det = determinant3x3(m);
        if(det == 0)   return null;

        double[][] inv = new double[3][3];
        inv[0][0] =  (m[1][1]*m[2][2] - m[1][2]*m[2][1]);
        inv[0][1] = -(m[0][1]*m[2][2] - m[0][2]*m[2][1]);
        inv[0][2] =  (m[0][1]*m[1][2] - m[0][2]*m[1][1]);
        inv[1][0] = -(m[1][0]*m[2][2] - m[1][2]*m[2][0]);
        inv[1][1] =  (m[0][0]*m[2][2] - m[0][2]*m[2][0]);
        inv[1][2] = -(m[0][0]*m[1][2] - m[0][2]*m[1][0]);
        inv[2][0] =  (m[1][0]*m[2][1] - m[1][1]*m[2][0]);
        inv[2][1] = -(m[0][0]*m[2][1] - m[0][1]*m[2][0]);
        inv[2][2] =  (m[0][0]*m[1][1] - m[0][1]*m[1][0]);

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                inv[i][j] = inv[i][j] / det;
			}
		}
        return inv;
    }

    // Method to display an int matrix
    public void displayMatrix(int[][] matrix){
        for(int[] row : matrix){
            for(int val : row){
                System.out.printf("%4d", val);
			}
            System.out.println();
		}
    }

    // Method to display a double matrix
    public void displayMatrix(double[][] matrix){
        for(double[] row : matrix){
            for(double val : row){
                System.out.printf("%8.2f", val);
			}
            System.out.println();
        }
    }

    public static void main(String[] args){
		MatrixOperations obj = new MatrixOperations();
		
		// 3x3 matrix operations
        int[][] A = obj.generateMatrix(3,3);
        int[][] B = obj.generateMatrix(3,3);

        System.out.println("Matrix A:");
        obj.displayMatrix(A);
        System.out.println("Matrix B:");
        obj.displayMatrix(B);

        System.out.println("A + B:");
        obj.displayMatrix(obj.addMatrices(A,B));

        System.out.println("A - B:");
        obj.displayMatrix(obj.subtractMatrices(A,B));

        System.out.println("A x B:");
        obj.displayMatrix(obj.multiplyMatrices(A,B));

        System.out.println("Transpose of A:");
        obj.displayMatrix(obj.transposeMatrix(A));

        System.out.println("Determinant of A: " + obj.determinant3x3(A));

        double[][] inverseA = obj.inverse3x3(A);
        if(inverseA != null){
            System.out.println("Inverse of A:");
            obj.displayMatrix(inverseA);
        }
		else{
            System.out.println("Matrix A is not invertible");
        }

        // 2x2 matrix operations
        System.out.println("\n--------- 2x2 Matrix ---------");
        int[][] C = obj.generateMatrix(2,2);
        System.out.println("Matrix C:");
        obj.displayMatrix(C);
        System.out.println("Determinant of C: " + obj.determinant2x2(C));
        double[][] inverseC = obj.inverse2x2(C);
        if(inverseC != null){
            System.out.println("Inverse of C:");
            obj.displayMatrix(inverseC);
        }
		else{
            System.out.println("Matrix C is not invertible");
        }
    }
}
