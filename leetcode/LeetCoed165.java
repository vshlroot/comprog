package leetcode;

/**
 * Created by vishalss on 1/16/2016.
 */
/*
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
 */
public class LeetCoed165 {
    public int compareVersion(String version1, String version2) {
        String s1[]=version1.split("\\.");
        String s2[]=version2.split("\\.");

        int flag=-1;
        int n;
        System.out.println(s1.length);
        System.out.println(s2.length);
        if(s1.length>s2.length){
            n=s2.length;
            flag=2;
        }
        else if(s1.length<s2.length){
            n=s1.length;
            flag=1;
        }
        else {
            n=s1.length;
            flag=3;
        }

        int v1,v2;
        int i;
        for ( i = 0; i <n ; i++) {
            v1=Integer.parseInt(s1[i]);
            v2=Integer.parseInt(s2[i]);
            if(v1>v2){
                return 1;
            }
            else if(v1<v2) {
                return -1;
            }
        }
        if(flag==1){
            while (i<s2.length) {
                v1 = Integer.parseInt(s2[i]);
                System.out.println("flag==1 and v1= " + v1);
                if (v1 > 0)
                    return -1;
                else if (v1 < 0)
                    return 1;
                i++;
            }
        }
        else if(flag==2){
            while (i<s1.length) {
                v1 = Integer.parseInt(s1[i]);
                System.out.println("flag==2 and v1= " + v1);
                if (v1 > 0)
                    return 1;
                else if (v1 < 0)
                    return -1;
                i++;
            }
        }
        System.out.println("Return default");
        return 0;
    }

    public static void main(String[] args) {
        String s="14.3";
        String s1[]=s.split(".");
        System.out.println(s1.length);
    }
}
