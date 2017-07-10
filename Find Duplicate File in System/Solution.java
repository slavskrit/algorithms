public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            List<String> files = new ArrayList<>();
            List<String> contents = new ArrayList<>();
            String directory = "";
            int i = 0;
            int j = 1;
            while (j++ < path.length()) {
                if (path.charAt(j) == ' ') {
                    directory = path.substring(i, j);
                    break;
                }
            }
            i = j + 1;
            while (j++ < path.length() - 1) {
                if (path.charAt(j) == '(') {
                    files.add(path.substring(i, j));
                    i = j + 1;
                } else if (path.charAt(j) == ')') {
                    contents.add(path.substring(i, j));
                    i = j + 2;
                }
            }
            for (int file = 0; file < files.size(); file++) {
                List<String> temp = map.get(contents.get(file));
                if (temp == null) {
                    List<String> t = new ArrayList<>();
                    t.add(directory + "/" + files.get(file));
                    map.put(contents.get(file), t);
                } else {
                    temp.add(directory + "/" + files.get(file));
                    map.put(contents.get(file), temp);
                }
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) result.add(entry.getValue());
        }
        return result;
    }
}
