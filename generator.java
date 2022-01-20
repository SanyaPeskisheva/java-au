public enum FileType{
    MARKDOWN("md"), HTML("html"), LATEX("LaTeX");
    private String mark;
    FileType(String mark){
        this.mark = mark;
    }
    public String getCode(){ return mark;}
}

import java.io.FileReader;
import java.io.IOException;

public class IOUtils {
    public static String readFile(String source) throws IOException {
        StringBuilder input = new StringBuilder();
        FileReader tfr = new FileReader(source);
        char[] buffer = new char[8096];
        int chars = tfr.read(buffer);
        while (chars != -1) {
            input.append(String.valueOf(buffer, 0, chars));
            chars = tfr.read(buffer);
        }
        tfr.close();
        return input.toString();
    }
}

public interface ItemEntity {
    String[] toFormatted();
}

import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        String source;
        StringBuilder mdFile;
        String inputName = "/home/SanyaPeskisheva/IdeaProjects/java_au/src/generate/" + args[0];
        String outName = "/home/SanyaPeskisheva/IdeaProjects/generate/" + args[1];
        source = IOUtils.readFile(inputName);
        mdFile = new StringBuilder(IOUtils.readFile(outName));
        System.out.println(args[2]);
        SolutionFile MyFile = SolutionFile.parse(mdFile.toString(), "md"); // fix "md" problem
        MyFile.solutions.add(MarkDownEntity.parse(source));
        mdFile = new StringBuilder();
        for (ItemEntity Ent : MyFile.solutions){
            mdFile.append(Ent.toFormatted()[0]);
        }
        mdFile.append("<!---->\n\n");
        for (ItemEntity Ent : MyFile.solutions){
            mdFile.append(Ent.toFormatted()[1]);
        }
        System.out.println(mdFile);
        FileWriter MdFile = new FileWriter(outName);
        MdFile.write(mdFile.toString());
        MdFile.flush();
        MdFile.close();
    }
}

import java.util.*;

public class MarkDownEntity  implements ItemEntity{
    String titleLink;
    String codeBlock;

    @Override
    public boolean equals(Object o) {

        if (this == o) {return true;}

        if (o == null || getClass() != o.getClass()) {return false;}

        MarkDownEntity MdEntity = (MarkDownEntity) o;
        return titleLink.equals(MdEntity.titleLink) && codeBlock.equals(MdEntity.codeBlock);
    }


    public MarkDownEntity(String titleLink, String codeBlock){
        this.titleLink = titleLink;
        this.codeBlock = codeBlock;
    }


    @Override
    public String[] toFormatted() {
        String[] forms = new String[2];
        forms[0] = titleLink;
        forms[1] = codeBlock;
        return forms;
    }


    public static List<MarkDownEntity> parseToMarkDownEntities(String OldFile){
        List<MarkDownEntity> result = new ArrayList<>();
        if (OldFile.length() == 0){
            return result;
        }
        String[] titleLinks = OldFile.split("<!---->\n")[0].split("\n");
        String codeBlocking = OldFile.split("<!---->\n")[1];
        String[] codeBlocks = codeBlocking.split("## ");

        HashMap<String, String> titles = new HashMap<>();
        for (String titleLink:
                titleLinks) {
            String title = titleLink.split("\\+ \\[")[1].split("]")[0];
            titles.put(title, titleLink + "\n");
        }
        for (String codeBlock:
                codeBlocks){
            String title = codeBlock.split("\n")[0];
            if (codeBlock.equals("")){
                continue;
            }
            if (titles.containsKey(title)){
                result.add(new MarkDownEntity(titles.get(title), "## " + codeBlock));
            }else{
                return null; // original MD file hasn't a pair "title - task"
            }
        }
        return result;
    }

    public static MarkDownEntity parse(String source){
        String title = source.split("\n")[0];
        String link = source.split("\n")[1];
        String codeBlock = source.split("\n", 3)[2];
        System.out.println(codeBlock);
        String titleTail = title.toLowerCase(Locale.ROOT).replace(" ", "-");
        String titleLink = String.format("+ [%s](#%s)\n", title, titleTail);
        codeBlock = "## " + title + "\n" + link + "\n```java\n" + codeBlock + "```\n";
        return new MarkDownEntity(titleLink, codeBlock);
    }
}

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MarkDownEntityTest {

    private final String PARSE_TEST = "title\ncode\nlink";
    private final String OLD_FILE = "+ [min-stack](#min-stack)\n" +
            "<!---->\n" +
            "## min-stack\n" +
            "https://leetcode.com/problems/min-stack/\n" +
            "```java\n" +
            "code block:\n" +
            "    privet\n" +
            "    prive\n" +
            "    privt\n" +
            "```\n";

    @org.junit.jupiter.api.Test
    void testEquals() {
    }

    @org.junit.jupiter.api.Test
    void parseToMarkDownEntities() {
        List<MarkDownEntity> res = MarkDownEntity.parseToMarkDownEntities(OLD_FILE);
        List<MarkDownEntity> exp = new ArrayList<>();
        exp.add(MarkDownEntity.parse("min-stack\n" +
                "https://leetcode.com/problems/min-stack/\n" +
                "code block:\n" +
                "    privet\n" +
                "    prive\n" +
                "    privt\n"));
        assertEquals(exp, res);
    }

    @org.junit.jupiter.api.Test
    void parse() {
        MarkDownEntity ans = MarkDownEntity.parse("min-stack\n" +
                "https://leetcode.com/problems/min-stack/\n" +
                "code block:\n" +
                "    privet\n" +
                "    prive\n" +
                "    privt\n");
        MarkDownEntity exp = new MarkDownEntity("+ [min-stack](#minstack)\n", "## min-stack\n" +
                "https://leetcode.com/problems/min-stack/\n" +
                "```java\n" +
                "code block:\n" +
                "    privet\n" +
                "    prive\n" +
                "    privt\n" +
                "```\n");
        assertEquals(ans, exp);
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SolutionFile {
    public final List<ItemEntity> solutions;

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        SolutionFile Solutions = (SolutionFile) o;
        return solutions.equals(Solutions.solutions);
    }

    public SolutionFile(List<ItemEntity> solutions) {
        this.solutions = solutions;
    }


    public static SolutionFile parse(String old, String type){
        List<ItemEntity> result = new ArrayList<>();
        if (type.equals(FileType.MARKDOWN.getCode())){
            result.addAll(Objects.requireNonNull(MarkDownEntity.parseToMarkDownEntities(old)));
        }
        return new SolutionFile(result);
    }
}

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionFileTest {
    private static String PARSE_OLD = "+ [min-stack](#min-stack)\n" +
            "<!---->\n" +
            "## min-stack\n" +
            "https://leetcode.com/problems/min-stack/\n" +
            "```java\n" +
            "code block:\n" +
            "    privet\n" +
            "    prive\n" +
            "    privt\n" +
            "```\n";
    private static String CODE = "min-stack\n" +
            "https://leetcode.com/problems/min-stack/\n" +
            "code block:\n" +
            "    privet\n" +
            "    prive\n" +
            "    privt\n";

    @org.junit.jupiter.api.Test
    void parse() {
        List<ItemEntity> result = new ArrayList<>();
        result.add(MarkDownEntity.parse(CODE));
        SolutionFile out = SolutionFile.parse(PARSE_OLD, "md");
        SolutionFile exp = new SolutionFile(result);
        assertEquals(out, exp);
    }
}
