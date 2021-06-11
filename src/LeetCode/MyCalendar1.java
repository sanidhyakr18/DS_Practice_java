package LeetCode;

import java.util.ArrayList;

public class MyCalendar1 {
    public static void main(String[] args) {
        MyCalendar obj = new MyCalendar();
        System.out.println(obj.book(47, 50));
        System.out.println(obj.book(33, 41));
        System.out.println(obj.book(39, 45));
        System.out.println(obj.book(33, 42));
        System.out.println(obj.book(25, 32));
        System.out.println(obj.book(26, 35));
        System.out.println(obj.book(19, 25));
        System.out.println(obj.book(3, 8));
        System.out.println(obj.book(8, 13));
        System.out.println(obj.book(18, 27));
    }
}

class MyCalendar {
    public static ArrayList<int[]> list;

    public MyCalendar() {
        list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        if (list.size() == 0) {
            list.add(new int[]{start, end});
            return true;
        } else if (end <= list.get(0)[0]){
            list.add(0, new int[]{start, end});
            return true;
        } else if (start >= list.get(list.size()-1)[1]){
            list.add(new int[]{start, end});
            return true;
        }

        for (int i = 0; i< list.size() - 1; i++) {
            if(start >= list.get(i)[1] && end <= list.get(i+1)[0]) {
                list.add(i+1, new int[]{start, end});
                return true;
            }
        }
        return false;
    }
}