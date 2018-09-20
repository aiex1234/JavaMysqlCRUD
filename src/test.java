import java.util.ArrayList;

public class test {

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        ArrayList newList = new ArrayList();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(10);

        for(int i = 0 ; i < 10 ; i++) {
            int number = (int) arrayList.get(i);
            if(number * 2 > 10) {
                newList.add("Value = " + number*2);
                System.out.println(newList);
            }
        }

        System.out.println(newList.size());

        for(int i = 0 ; i < newList.size() - 1 ; i++) {
            System.out.println(newList.get(i));
        }
    }
}
