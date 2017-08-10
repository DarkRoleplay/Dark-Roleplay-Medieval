package net.dark_roleplay.medieval.common.util.math;

public class MatrixSolver {

	public static double[] solve(double[][] a, double[] x) {
		int length = x.length;
		for (int i = 0; i < length; i++) {
			// Tauscht 2 Zeilen der Matrix fals a[i][i]=0
			if (a[i][i] == 0) {
				int j = i + 1;

				while ((a[j][i] == 0) && (j < (length - 1))) {
					j = j + 1;
				}
				double tauscher = x[i];
				x[i] = x[j];
				x[j] = tauscher;
				for (int k = i; k < length; k++) {
					tauscher = a[i][k];
					a[i][k] = a[j][k];
					a[j][k] = tauscher;
				}
			}
			// a[i][i] wird 1
			// unter der Dagonalen wird alles 0
			// bsp;
			// (1 | x1,2 |x1,3) (L1(L2(L3)))
			// (0 | 1 |x2,3) (L2(L3))
			// (0 | 0 | 1 ) (L3)

			double div = a[i][i];
			x[i] = x[i] / div;

			for (int j = i; j < length; j++) {
				a[i][j] = a[i][j] / div;
			}

			for (int z = i + 1; z < length; z++) {
				double mult = a[z][i];
				x[z] = x[z] - (x[i] * mult);
				for (int y = i; y < length; y++) {
					a[z][y] = a[z][y] - (a[i][y] * mult);
				}
			}

			// über der Dagonalen wird alles 0
			// bsp;
			// (1 | 0 |0) (L1)
			// (0 | 1 |0) (L2)
			// (0 | 0 |1) (L3)
			for (int z = length - 1; z >= 0; z--) {
				double mult = a[z][i];
				x[z] = x[z] - (x[i] * mult);
				for (int y = z - 1; y >= 0; y--) {
					x[y] = x[y] - (x[z] * a[z][y]);
					a[z][y] = 0;
				}
			}

		}

		return x;
	}

}
