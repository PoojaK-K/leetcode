class Solution {
    public int[][] merge(int[][] intervals) {
        int max=0;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][1]>max){
                max=intervals[i][1];
            }
        }
        int arr[]=new int[2*max+3];
        for(int i=0;i<intervals.length;i++){
            arr[2*(intervals[i][0])]++;
            arr[2*intervals[i][1]+1]--;
        }
        int count=0;
        for(int i=1;i<arr.length;i++){
            arr[i]+=arr[i-1];
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0 && (i==0 || arr[i-1]==0)){
                count++;
            }
        }
        int ans[][]=new int[count][2];
        int low=0;
        int high=0;
        
        int index=0;
        while(high<arr.length){
            while(high<arr.length && arr[high]==0){
                high++;
            }
            if(high>=arr.length)break;
            low=high;
            while(high<arr.length && arr[high]>0){
                high++;
            }
            
                ans[index][0]=low/2;
                ans[index][1]=(high-1)/2;
                index++;
                
            


        }
        return ans;

    }
}