import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		recur(n);
	}
	
	public static void recur(int n) {
		if (n == 0) {
			System.out.println(sb+"\"����Լ��� ������?\"");
			System.out.println(sb+"\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
			System.out.println(sb+"��� �亯�Ͽ���.");
			return;
		}
		else {
			System.out.println(sb+"\"����Լ��� ������?\"");
			System.out.println(sb+"\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.");
			System.out.println(sb+"���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.");
			System.out.println(sb+"���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");
			sb.append("____");
			recur(n-1);
			sb.delete(sb.length()-4,sb.length());
		}
		System.out.println(sb+"��� �亯�Ͽ���.");
	}
}