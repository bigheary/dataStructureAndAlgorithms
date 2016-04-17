package leetCode;

public class MedianOfTwoSortedArrays {
/*	public static int findKth(int[] a, int sa, int[] b, int sb, int k){
		if(a == null || b == null ){
	        if(a == null)
	            return b[k - 1];
	        else
	            return a[k - 1];
	    }
		if (sa == a.length) {
			if (sb + k - 1< b.length) {
				return b[sb + k - 1];
			}else {
				return -1;
			}
		}else if(sb == b.length) {
			if (sa + k - 1< a.length) {
				return a[sa + k - 1];
			}else {
				return -1;
			}
		}
		
		if (k == 1) {
			return a[sa] < b[sb] ? a[sa] : b[sb];
		}
		
		int la = a.length - sa;
		int lb = b.length - sb;
		
		int p = (la * k)/(la + lb) + sa - 1 > sa ? (la * k)/(la + lb) + sa - 1 : sa;
		int q = k - (p - sa + 1) + sb - 1;
		
		if (a[p] == b[q]) {
			return a[p];
		}else if(a[p] < b[q]) {
			return findKth(a, p+1, b, sb, k-(p - sa + 1));
		}else{
			return findKth(a, sa, b, q+1, k-(q - sb + 1));
		}
	}*/
	
	
	public int findKth(int[] a, int sa, int[] b, int sb, int k){
	    if(a == null || b == null ){
	        if(a == null)
	            return b[k - 1];
	        else
	            return a[k - 1];
	    }
	    if (sa == a.length) {
		    if (sb + k - 1< b.length) {
			    return b[sb + k - 1];
		    }else {
			    return -1;
		    }
	    }else if(sb == b.length) {
		    if (sa + k - 1< a.length) {
			    return a[sa + k - 1];
		    }else {
			    return -1;
		    }
	    }
	
	    if (k == 1) {
		    return a[sa] < b[sb] ? a[sa] : b[sb];
	    }
	
	    int la = a.length - sa;
	    int lb = b.length - sb;
	    int p = (la * k)/(la + lb) + sa - 1 > sa ? (la * k)/(la + lb) + sa - 1 : sa;
	    int q = k - (p - sa + 1) + sb - 1;
	
	    if (a[p] == b[q]) {
		    return a[p];
	    }else if(a[p] < b[q]) {
		    return findKth(a, p+1, b, sb, k-(p - sa + 1));
	    }else{
		    return findKth(a, sa, b, q+1, k-(q - sb + 1));
	    }
    }


/*public double findKth(int a[], int m, int b[], int n, int k){
    //always assume that m is equal or smaller than n
    if (m > n)
	    return findKth(b, n, a, m, k);
    if (m == 0)
	    return b[k - 1];
    if (k == 1)
	    return min(a[0], b[0]);
    //divide k into two parts
    int pa = min(k / 2, m), pb = k - pa;
    if (a[pa - 1] < b[pb - 1])
	    return findKth(a + pa, m - pa, b, n, k - pa);
    else if (a[pa - 1] > b[pb - 1])
	    return findKth(a, m, b + pb, n - pb, k - pb);
    else
	    return a[pa - 1];
}*/

public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //return findKth(nums1, 0, nums2, 0, (nums1.length + nums2.length + 1)/2);
    int total = nums1.length + nums2.length;
	if ((total & 0x1) != 0)
		return findKth(nums1, 0, nums2, 0, total / 2 + 1);
	else
		return (findKth(nums1, 0, nums2, 0, total / 2)
				+ findKth(nums1, 0, nums2, 0, total / 2 + 1)) / 2.0d;
				
}
	
	public static void main(String[] args){
		int[] a = {1, 2};
		int[] b = {1, 2, 3};
		System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(a, b));
		System.out.println(2.0d);
	}
	
}
