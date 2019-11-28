[TOC]

# LeetCode-Easy5-Top81_100

-   Problems-ID：268、 **270** 、 **276** 、278、283、290、292、 **293** 、299、303、326、 **339** 、342、345、 **346** 、349、 **359** 、367

## [268. Missing Number](https://leetcode.com/problems/missing-number/)

### 题解（数组）-2019年11月15日

-   求和作差，或者，亦或

```java
public class P268_MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = (1+n)*n/2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return total - sum;
    }
}
```

## [LOCKED UP]270. Closest Binary Search Tree Value

## [LOCKED UP]276. Paint Fence

## [278. First Bad Version](https://leetcode.com/problems/first-bad-version/)

### 题解（二分查找）-2019年11月16日

```java
public int firstBadVersion(int n) {
	int left = 1;
	int right = n;
	while (left<right){
		int mid = (left+right)/2;//这样可能会出错。应该用long
		if (isBadVersion(mid)) {
			right = mid;
		} else {
			left = mid+1;
		}
	}
	System.out.println(left);
	System.out.println(right);
	return  left;
}
```

## [283. Move Zeroes](https://leetcode.com/problems/move-zeroes/)

### 题解（数组）-2019年11月17日

```java
public class P283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (index < i) {
                    nums[index] = nums[i];
                    nums[i]=0;
                }
                index++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
```

## [290. Word Pattern](https://leetcode.com/problems/word-pattern/)

### 题解（集合）-2019年11月18日

-   注意，maps.containsValue的时间复杂度是O(n)

```java
public boolean wordPattern(String pattern, String str) {
	String[] words = str.split(" ");
	HashMap<Character, String> maps = new HashMap<>();
	HashSet<String> visited = new HashSet<>();
	if (pattern.length()!=words.length){
		return false;
	}
	for (int i = 0; i < pattern.length(); i++) {
		if(!maps.containsKey(pattern.charAt(i)) && !visited.contains(words[i])){
			maps.put(pattern.charAt(i), words[i]);
			visited.add(words[i]);
		}
	}
	for (int i = 0; i < pattern.length(); i++) {
		char c = pattern.charAt(i);
		if (!maps.containsKey(c)) {
			return false;
		}
		String s = maps.get(c);
		if (!s.equals(words[i])) {
			return false;
		}
	}
	return true;
}
```

## [292. Nim Game](https://leetcode.com/problems/nim-game/)

### 题解-2019年11月19日

-   数学题

```java
public boolean canWinNim(int n) {
    return !(n%4==0);
}
```

## [LOCKED UP]293. Flip Game

## [299. Bulls and Cows](https://leetcode.com/problems/bulls-and-cows/)

### 题解（字符串）-2019年11月20日

```java
public String getHint(String secret, String guess) {
	int bulls = 0;
	int cows = 0;
	int[] secretT = new int[10];
	int[] guessT = new int[10];
	for (int i = 0; i < secret.length(); i++) {
		if (secret.charAt(i) == guess.charAt(i)) {
			bulls++;
		}else {
			secretT[secret.charAt(i)-'0'] += 1;
			guessT[guess.charAt(i)-'0'] += 1;
		}
	 }
	for (int i = 0; i < 10; i++) {
		cows += Math.min(secretT[i], guessT[i]);
	}
	return bulls+"A"+cows+"B";
}
```

## [303. Range Sum Query - Immutable](https://leetcode.com/problems/range-sum-query-immutable/)

### 题解（数组）-2019年11月21日

```java
public class P303_RangeSumQueryImmutable {
    private  int[] sums;
    public P303_RangeSumQueryImmutable(int[] nums) {
        int n = nums.length;
        sums = new int[n+1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }
    public int sumRange(int i, int j) {
        return sums[j+1]-sums[i];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        P303_RangeSumQueryImmutable test = new P303_RangeSumQueryImmutable(nums);
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        System.out.println(test.sumRange(i,j));
    }
}
```

## [326. Power of Three](https://leetcode.com/problems/power-of-three/)

### 题解-2019年11月22日

```java
public class P326_PowerofThree {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n > 1) {
            if (n % 3 == 0) {
                n = n / 3;
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        P326_PowerofThree test = new P326_PowerofThree();
        System.out.println(test.isPowerOfThree(n));
    }
}
```

## [LOCKED UP]339. Nested List Weight Sum

## [342. Power of Four](https://leetcode.com/problems/power-of-four/)

### 题解-2019年11月23日

```java
public class P342_PowerofFour {
    public boolean isPowerOfFour(int n) {
        while(n%4 == 0 && n>0) n =n/4;
        return n==1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        P342_PowerofFour test = new P342_PowerofFour();
        System.out.println(test.isPowerOfFour(n));
    }
}
```

## [344. Reverse String](https://leetcode.com/problems/reverse-string/)

### 题解（字符串与字符数组）-2019年11月24日

```java
public class P344_ReverseString {
    public void reverseString(char[] s) {
        for(int i = 0,j = s.length - 1; i < j; i++, j--) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
        }
    }
    public static void main(String[] args) {
        P344_ReverseString test = new P344_ReverseString();
        String str ="hello";
        test.reverseString(str.toCharArray());
    }
}
```

## [345. Reverse Vowels of a String](https://leetcode.com/problems/reverse-vowels-of-a-string/)

### 题解（字符串与字符数组，Hashset）-2019年11月25日

```java
public class P345_ReverseVowelsofaString {
    private Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
    public String reverseVowels(String s) {
        char c[] = s.toCharArray();
        int i=0,j=s.length()-1;
        while (i < j) {
            while (i<s.length()&&!vowels.contains(c[i])){
                i++;
            }
            while (j > 0 && !vowels.contains(c[j])) {
                j--;
            }
            if (i < j) {
                char t = c[i];
                c[i] = c[j];
                c[j] = t;
                i++;j--;
            }
        }
        return String.valueOf(c);
    }
    public static void main(String[] args) {
        P345_ReverseVowelsofaString test = new P345_ReverseVowelsofaString();
        String str ="hello";
        System.out.println(test.reverseVowels(str));
    }
}
```

## [LOCKED UP]346. Moving Average from Data Stream

## [349. Intersection of Two Arrays](https://leetcode.com/problems/intersection-of-two-arrays/)

### 题解（哈希）-2019年11月26日

```java
public class P349_IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int value : nums1) {
            set.add(value);
        }
        for (int value:nums2) {
            if (set.contains(value)) {
                res.add(value);
                set.remove(value);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};

        P349_IntersectionofTwoArrays test = new P349_IntersectionofTwoArrays();
        System.out.println(Arrays.toString(test.intersection(nums1,nums2)));
    }
}
```

## [350. Intersection of Two Arrays II](https://leetcode.com/problems/intersection-of-two-arrays-ii/)

### 题解-2019年11月27日

```java
public class P350_IntersectionofTwoArraysII {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0, k = 0;
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res[k++] = nums1[i];
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]) {
                i++;
            }
            else {
                j++;
            }
        }
        return Arrays.copyOf(res, k);
    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        P350_IntersectionofTwoArraysII test = new P350_IntersectionofTwoArraysII();
        System.out.println(Arrays.toString(test.intersection(nums1,nums2)));
    }
}
```

## [LOCKED UP]359. Logger Rate Limiter

## [367. Valid Perfect Square](https://leetcode.com/problems/valid-perfect-square/)

### 题解（二分）-2019年11月28日

```java
public class P367_ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int lo = 1, hi = num;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            int res = num/mid, tail = num%mid;  //Prevents overflow
            if(res==mid && tail==0) return true;
            else if(res>mid) lo = mid+1;
            else hi = mid-1;
        }
        return false;
    }
    public static void main(String[] args) {
        int n = 14;
        P367_ValidPerfectSquare test = new P367_ValidPerfectSquare();
        System.out.println(test.isPerfectSquare(n));
    }
}
```
