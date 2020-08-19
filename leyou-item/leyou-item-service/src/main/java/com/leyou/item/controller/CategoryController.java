package com.leyou.item.controller;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 根据父节点查询子节点
     * @param pid
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoriesByPid(@RequestParam(value = "pid", defaultValue = "0") Long pid) {
//        try {
//            if (pid == 0 || pid < 0) {
//                //400;参数不合法
////                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
////                    return new  ResponseEntity<>(HttpStatus.BAD_REQUEST);
//                return ResponseEntity.badRequest().build();
//            }
////         public ResponseEntity<list<Category>> queryCategoriesByPid(@RequestParam(value = "pid",defaultValue = "0")long pid){
////             if(pid == 0|| pid < 0){
////                 return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
////
////             }
//
//            List<Category> categories = this.categoryService.querCategoriesByid(pid);
//            //错误写法，报空指针异常。如果categories ==null
////         if (categories.size()==0||categories ==null){
////
////         }
////        if (categories == null || categories.size() == 0) {
////        }
//            //404:资源服务器未找到
//            if (CollectionUtils.isEmpty(categories)){
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//
//            }
//                //200 查询成功
//            return ResponseEntity.ok(categories);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //500 服务器内部异常
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();


//最终版的代码
        //此处有异常自动报500，所以可以不用try-catch
            if (pid == null || pid < 0) {
                //400;参数不合法
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//                    return new  ResponseEntity<>(HttpStatus.BAD_REQUEST);
                return ResponseEntity.badRequest().build();
            }
//         public ResponseEntity<list<Category>> queryCategoriesByPid(@RequestParam(value = "pid",defaultValue = "0")long pid){
//             if(pid == 0|| pid < 0){
//                 return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//
//             }

            List<Category> categories = this.categoryService.queryCategoriesByid(pid);
            //错误写法，报空指针异常。如果categories ==null
//         if (categories.size()==0||categories ==null){
//
//         }
//        if (categories == null || categories.size() == 0) {
//        }
            //404:资源服务器未找到
            if (CollectionUtils.isEmpty(categories)){
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                    return ResponseEntity.notFound().build();
            }
            //200 查询成功
            return ResponseEntity.ok(categories);

    }

    @GetMapping
    public ResponseEntity<List<String>> queryNamesByIds(@RequestParam("ids")List<Long> ids){

        List<String> names = this.categoryService.queryNamesByIds(ids);
        if (CollectionUtils.isEmpty(names)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(names);
    }
}
