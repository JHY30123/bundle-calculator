import com.codetest.Bundle;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        int v[] = {Integer.MAX_VALUE,3, 5, 9};

        int w[] = {Integer.MAX_VALUE,570, 900, 1530};

        ////////////////////////////////////////////////////////////
        int target = 18;
        ///////////////////////////////////////////////////////////

        int[][] f = new int[5][target + 1];
        for(int[] row: f)
            Arrays.fill(row, Integer.MAX_VALUE);

        for(int i = 1; i <= 3; i ++)
            for(int j = 1; j <= target; j ++){
                f[i][j] = Math.min(f[i][j],f[i - 1][j]);
                if(j <= v[i]) f[i][j] = Math.min(f[i][j], w[i]);
                else f[i][j] = Math.min(f[i][j], f[i][j - v[i]] + w[i]);
            }
        System.out.println(f[3][target]);
    }

}
