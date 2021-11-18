/**
 * Converts Solution-String from task 5 to a boolean [][] representation of the solution path.
 * @param solutionString String representation of the exit-ways.
 * @param width          width of the labyrinth
 * @param height         height of the labyrinth
 * @return              2D representation of the routes where true indicates that the route is part of the exit-way.
 */
static boolean[][] solutionStringToTable(String solutionString, int width, int height) {
    boolean[][] solution = new boolean[height][width];
    java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\(([0-9]+),([0-9]+)\\)");
    java.util.regex.Matcher m = p.matcher(solutionString.replaceAll("\\s",""));
    while (m.find()) {
        int x = Integer.parseInt(m.group(1));
        int y = Integer.parseInt(m.group(2));
        solution[y][x] = true;
    }
    return solution;
}
