/**
 * Created by 孙亮 on 2017/5/11.
 */
public class BinaryAdd {
    public String addBinary(String a, String b) {
        boolean jinwei = false;
        String s = new String();

        int i = a.length()-1, j = b.length()-1;
        for(; i >= 0 && j >=0; i--, j--) {
            String tmp = "0";
            boolean mark = false;
            if(a.charAt(i) == '0' && b.charAt(j) == '0') {
                tmp = "0";
            }
            if((a.charAt(i) == '0' && b.charAt(j) == '1')
                    || (a.charAt(i) == '1' && b.charAt(j) == '0')) {
                tmp = "1";
            }
            if(a.charAt(i) == '1' && b.charAt(j) == '1') {
                tmp = "0";
                mark = true;
            }

            if(tmp.equals("0") && jinwei) {
                jinwei = mark;
                s = "1" + s;
            } else if(tmp.equals("0") && !jinwei) {
                jinwei = mark;
                s = "0" + s;
            } else if(tmp.equals("1") && jinwei) {
                jinwei = true;
                s = "0" + s;
            } else if(tmp.equals("1") && !jinwei) {
                jinwei = false;
                s = "1" + s;
            }
        }

        if(i >= 0) {
            return add(s, a, i, jinwei);
        }
        if(j >= 0) {
            return add(s, b, j, jinwei);
        }

        if(i < 0 && j <0) {
            if (jinwei) {
                s = "1" + s;
            }
        }

        return s;
    }

    public String add(String s, String a, int i, boolean jinwei) {
        for(; i >=0; i --) {
            if(jinwei && a.charAt(i) == '1') {
                jinwei = true;
                s = "0" + s;
            } else if(jinwei && a.charAt(i) == '0') {
                jinwei = false;
                s = "1" + s;
            } else if(!jinwei) {
                s = String.valueOf(a.charAt(i)) + s;
            }
        }
        if(jinwei) {
            s = "1" + s;
        }
        return s;
    }
}
