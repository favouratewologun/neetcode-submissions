class Solution {
    public List<String> generateParenthesis(int n) {
        //count num open, can only close if have at least 1 open.
        List<String> res = new ArrayList<>();
        StringBuilder sol = new StringBuilder();

        backtracking(res, sol, n, 0, 0);

        return res;
        
    }

    private void backtracking(List<String> res, StringBuilder sol, int n, int open, int closed) {
        //closed must be <= opened
        //if closed == opened can only do backtracking with an open
        if (closed == n) { //closed all, so done
            res.add(sol.toString());
            return;
        }

        if (open > n) //failed
            return;

        if (closed == open) {
            sol.append('(');
            backtracking(res, sol, n, open + 1, closed);
            sol.deleteCharAt(sol.length() - 1);
            
        } else { //closed < opened
            sol.append('(');
            backtracking(res, sol, n, open + 1, closed);
            sol.deleteCharAt(sol.length() - 1);

            sol.append(')');
            backtracking(res, sol, n, open, closed + 1);
            sol.deleteCharAt(sol.length() - 1);
        }

        //if closed < opened, can  do backtracking with both
    }


}
