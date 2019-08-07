import java.util.Scanner;

/*
Program to expand the string specified in the bracket with the number in the outside.
Question is from Google Tech Dev Guide
Sample Input Output:
Input: 1[1[1[1[1[1[1[1[1[1[1[1[1[1[1[1[1[1[1[1[xx]]]]]]]]]]]]]]]]]]]]
Output: xx
Input: 3[abc]4[ab]c
Output: abcabcabcababababc
Input: 10[a]
Output: aaaaaaaaaa
Input: 2[3[a]b]
Output: aaabaaab
*/

public class DecompressString {
    public static void main(String[] args) {
        CharacterStack stack = new CharacterStack();
        Scanner scan = new Scanner(System.in);
        String input;
        System.out.println("Enter the input string: ");
        input = scan.nextLine();
        processInput(stack, input);

    }

    private static void processInput(CharacterStack stack, String input) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ']') {
                StringBuilder tempBuilder = new StringBuilder();
                while (stack.topElement() >= 97 && stack.topElement() <= 122) {
                    if (!stack.isEmpty()) {
                        tempBuilder.append(stack.pop());
                    }
                }
                tempBuilder.reverse();
                stringBuilder.append(tempBuilder.toString());
                //Pop the open brace
                if (stack.topElement() == '[') {
                    stack.pop();
                }
                if (!stack.isEmpty()) {//Below lines will pop the number and store it in stringbuilder and revers it as we used stack.
                    StringBuilder builder = new StringBuilder();
                    while (!stack.isEmpty() && stack.topElement() >= 48 && stack.topElement() <= 57) {
                        builder.append(stack.pop());
                    }
                    int count = Integer.parseInt(builder.reverse().toString());
                    String str = stringBuilder.toString();
                    stringBuilder.append(str.repeat(Math.max(0, count - 1)));
                    if(count<=0){
                        stringBuilder.delete(0, stringBuilder.length());
                    }
                }
                if (stack.isEmpty()) {
                    System.out.print(stringBuilder.toString());
                    stringBuilder.delete(0, stringBuilder.length());
                }
            } else {
                stack.push(input.charAt(i));
            }
        }
        if(!stack.isEmpty()){
            while (!stack.isEmpty()&&stack.topElement() >= 97 && stack.topElement() <= 122){
                System.out.print(stack.pop());
            }
        }
    }
}


