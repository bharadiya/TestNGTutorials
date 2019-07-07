package ExcelReader;

import java.io.IOException;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) throws IOException {
		GetDataFromExcel g = new GetDataFromExcel(
				"/home/sb/eclipse-workspace/HybridFramework/src/test/java/com/inetbanking/testdata/UserandPassword.xlsx",
				0);
		System.out.println(Arrays.deepToString(g.getData()));
	}
}
