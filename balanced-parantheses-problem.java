// A string containing only parentheses is balanced if the following is true: 1. if it is an empty string 2. if A and B are correct, AB is correct, 3. if A is correct, (A) and {A} and [A] are also correct.
//
// Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"
//
// Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.
//
// Given a string, determine if it is balanced or not.


private static Character Opening_Paranthesis = '(';
private static Character Closing_Paranthesis = ')';
private static Character Opening_Brace = '{';
private static Character Closing_Brace = '}';
private static Character Opening_Bracket = '[';
private static Character Closing_Bracket = ']';

 public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> values = new ArrayList<String>();
        while (sc.hasNext()) {
            String input=sc.next();
            values.add(input);
        }
        //Test cases
//                values.add("({}[])");//should return true
//                values.add("(({()})))");//should return false
//                values.add("({(){}()})()({(){}()})(){()}");//should return true
//                values.add("{}()))(()()({}}{}");//should return false
//                values.add("}}}}");//should return false
//                values.add("))))");//should return false
//                values.add("{{{");//should return false
//                values.add("(((");//should return false
//                values.add("[]{}(){()}((())){{{}}}{()()}{{}{}}");//should return true
//                values.add("[[]][][]");//should return true

        boolean[] result = calculateBalanced(values);

        for(int i = 0; i < result.length;i++){
            System.out.println(result[i]);
        }
    }

static boolean[] calculateBalanced(ArrayList<String> values){
        boolean[] result = new boolean[values.size()];
        for (int i = 0; i < values.size(); i++) {
            Stack<Character> stack = new Stack<Character>();

            for (int j = 0; j < values.get(i).length(); j++) {

                if (values.get(i).charAt(j) == Opening_Paranthesis)
                    stack.push(Opening_Paranthesis);

                else if (values.get(i).charAt(j) == Opening_Brace)
                    stack.push(Opening_Brace);

                else if (values.get(i).charAt(j) == Opening_Bracket)
                    stack.push(Opening_Bracket);


                else if (values.get(i).charAt(j) == Closing_Paranthesis)
                    if (!stack.isEmpty() && (stack.pop() == Opening_Paranthesis))
                        result[i] = true;
                    else {
                        result[i] = false;
                        break;
                    }

                else if (values.get(i).charAt(j) == Closing_Brace)
                    if (!stack.isEmpty() && (stack.pop() == Opening_Brace))
                        result[i] = true;
                    else {
                        result[i] = false;
                        break;
                    }

                else if (values.get(i).charAt(j) == Closing_Bracket)
                    if (!stack.isEmpty() && (stack.pop() == Opening_Bracket))
                        result[i] = true;
                    else {
                        result[i] = false;
                        break;
                    }
            }
            result[i] = result[i] && stack.isEmpty();
        }

        return result;
    }
