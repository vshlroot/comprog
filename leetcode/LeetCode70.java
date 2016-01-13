 public int climbStairs(int n) {
        int i=3;
        int step1=1,step2=2;
        if(n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        int result=0;
        while(i<=n){
            result=step1+step2;
            step1=step2;
            step2=result;
            i++;
        }
        return result;
    }
