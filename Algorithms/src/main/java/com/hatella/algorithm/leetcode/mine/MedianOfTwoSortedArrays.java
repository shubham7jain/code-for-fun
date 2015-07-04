package com.hatella.algorithm.leetcode.mine;

public class MedianOfTwoSortedArrays {
	
	public static void main(String args[]) {
		MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
		System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{11, 15, 20, 30, 32 }, new int[]{10, 11, 12, 15, 20}));
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		
		MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
		return medianOfTwoSortedArrays.finMedian(nums1, 0, m-1, nums2, 0, n-1);
	}
	int max( int a, int b )
	{ return a > b ? a : b; }
	 
	// A utility function to find minimum of two integers
	int min( int a, int b )
	{ return a < b ? a : b; }
	 
	// A utility function to find median of two integers
	double MO2( int a, int b )
	{ return ( a + b ) / 2.0; }
	 
	// A utility function to find median of three integers
	double MO3( int a, int b, int c )
	{
	    return a + b + c - max( a, max( b, c ) )
	                     - min( a, min( b, c ) );
	}
	 
	// A utility function to find median of four integers
	double MO4( int a, int b, int c, int d )
	{
	    int Max = max( a, max( b, max( c, d ) ) );
	    int Min = min( a, min( b, min( c, d ) ) );
	    return ( a + b + c + d - Max - Min ) / 2.0;
	}
	
	public double finMedian(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2) {
		int len1 = end1 - start1 + 1;
		int len2 = end2 - start2 + 1;
		
		if(len1 == 1) {
			if(len2 == 1) {
				return MO2(nums1[0], nums2[0]);
			} 
			if(len2%2 == 1) {
				return MO2( nums2[len2/2], (int)MO3(nums1[0], nums2[len2/2 - 1], nums2[len2/2 + 1]) );
			}
			if(len2%2 == 0) {
				return MO3( nums2[len2/2], nums2[len2/2 - 1], nums1[0] );
			}
		} else if(len1 == 2) {
			if( len2 == 2)
	            return MO4( nums1[0], nums1[1], nums2[0], nums2[1] );
			if( len2%2 == 1 )
	            return MO3 ( nums2[len2/2],
	                         max( nums1[0], nums2[len2/2 - 1] ),
	                         min( nums1[1], nums2[len2/2 + 1] )
	                       );
			 return MO4 ( nums2[len2/2],
					 nums2[len2/2 - 1],
                     max( nums1[0], nums2[len2/2 - 2] ),
                     min( nums1[1], nums2[len2/2 + 1] )
                   );
		} 
			int mid1 = start1 + len1/2;
			int mid2 = start2 + len2/2;
			if(nums1[mid1] > nums2[mid2]) {
				start1 = mid1;
				end2 = mid2;				
			} else {
				start2 = mid2;
				end1 = mid1;
			}
			return finMedian(nums1, start1, end1, nums2, start2, end2);
	}
}
