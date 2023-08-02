public class StringBuilder {
   private char[] value;
   private int count;
   
   public StringBuilder() {
      this(16);
   }
   
   public StringBuilder(int capacity) {
      value = new char[capacity];
   }
   
   public StringBuilder(String str) {
      this(str.length() + 16);
      append(str);
   }
   
   public StringBuilder append(String str) {
      if (str == null) {
         str = "null";
      }
      int len = str.length();
      ensureCapacityInternal(count + len);
      str.getChars(0, len, value, count);
      count += len;
      return this;
   }
   
   public StringBuilder append(Object obj) {
      return append(String.valueOf(obj));
   }
   
   public StringBuilder append(char[] str) {
      if (str == null) {
         str = "null".toCharArray();
      }
      int len = str.length;
      ensureCapacityInternal(count + len);
      System.arraycopy(str, 0, value, count, len);
      count += len;
      return this;
   }
   
   public StringBuilder append(char[] str, int offset, int len) {
      if (str == null) {
         str = "null".toCharArray();
      }
      if (offset < 0 || len < 0 || offset > str.length - len) {
         throw new IndexOutOfBoundsException();
      }
      ensureCapacityInternal(count + len);
      System.arraycopy(str, offset, value, count, len);
      count += len;
      return this;
   }
   
   public StringBuilder append(char ch) {
      ensureCapacityInternal(count + 1);
      value[count++] = ch;
      return this;
   }
   
   private void ensureCapacityInternal(int minimumCapacity) {
      if (minimumCapacity - value.length > 0) {
         expandCapacity(minimumCapacity);
      }
   }
   
   private void expandCapacity(int minimumCapacity) {
      int newCapacity = value.length * 2 + 2;
      if (newCapacity - minimumCapacity < 0) {
         newCapacity = minimumCapacity;
      }
      if (newCapacity < 0) {
         if (minimumCapacity < 0) {
            throw new OutOfMemoryError();
         }
         newCapacity = Integer.MAX_VALUE;
      }
      value = Arrays.copyOf(value, newCapacity);
   }
   
   public StringBuilder delete(int start, int end) {
      if (start < 0 || end < 0 || end > count || start > end) {
         throw new StringIndexOutOfBoundsException();
      }
      int len = end - start;
      if (len > 0) {
         System.arraycopy(value, end, value, start, count - end);
         count -= len;
      }
      return this;
   }
   
   public StringBuilder deleteCharAt(int index) {
      if (index < 0 || index >= count) {
         throw new StringIndexOutOfBoundsException();
      }
      System.arraycopy(value, index + 1, value, index, count - index - 1);
      count--;
      return this;
   }
   
   public StringBuilder replace(int start, int end, String str) {
      if (start < 0 || end < 0 || end > count || start > end) {
         throw new StringIndexOutOfBoundsException();
      }
      int len = str.length();
      int newCount = count - (end - start) + len;
      ensureCapacityInternal(newCount);
      System.arraycopy(value, end, value, start + len, count - end);
      str.getChars(0, len, value, start);
      count = newCount;
      return this;
   }
