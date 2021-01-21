package top.youlanqiang.fazer.controller;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * @author youlanqiang
 * created in 2021/1/21 20:00
 */
@RestController
public class GitController {

    @GetMapping("/create")
    public String create() throws GitAPIException {
        File file = new File("G:\\test\\dev\\testUser\\hello");
        file.mkdirs();
        Git.init().setDirectory(file).call();
        return "创建成功.";
    }
}
