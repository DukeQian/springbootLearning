package com.example.one;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoanAppController {


    private Map<String, Object> result = new HashMap<>();

    /**
     * 未登录，登录时候，查询产品信息
     *
     */
    @PostMapping(value = "index/getIndexLoansProductInfo.do")
    public Map<String, Object> getIndexLoansProductInfo(@RequestParam(required = false)String userId){
        System.out.println(userId);
        //userId 是否登录
        //查询产品列表 select * from t_loan_product tlp where enable=0
        //TODO 展现分为企业和个人
        //TODO 添加借款攻略
        //TODO 多个标 按请求时间先后的进行排序 最新的放第一位
        //判断是否有在途进件，如果有，查询到该产品的信息
        //查询该进件的信息，进度，状态
        return result;
    }

    /**
     * 申请借款 选择产品，点击提交按钮，准备录入信息的时候
     *
     */
    @PostMapping(value = "riskCamera/initCamera.do")
    public Map<String, Object> initCamera(
            @RequestParam String userId,
            @RequestParam String productId
    )
    {
        System.out.println(userId + productId);
        //查询产品信息【期限，上限金额，下限金额】
        //TODO 拦截——判断是否有在途进件， 支持多笔在途
        //拦截——判断是否实名认证
        //拦截——判断年龄限制
        //拦截——判断该用户是否开通存管账户,跳转到开户页面
        //TODO 拦截——判断是否是个人开户 提示：企业用户不能在APP申请借款
        //TODO 没必要初始化进件
        //TODO 标志位——身份验证这个标识哦，是否在这边放置，查询该用户身份证OCR、人脸识别、绑定银行卡三项

        return result;
    }


    /**
     * 贷款说明
     *
     */
    @PostMapping(value = "page/loanInstruction.do")
    public Map<String, Object> loanInstruction(
            @RequestParam String productId
    )
    {
        System.out.println(productId);
        //TODO 我这边点开测试环境，看到一些问题，还款方式没有显示出来，贷后管理费没有显示出来
        return result;
    }


    /**
     * 查询身份验证状态
     *
     */
    @PostMapping(value = "identity/queryIdentityStatus.do")
    public Map<String, Object> queryIdentityStatus(
            @RequestParam String userId
    )
    {
        System.out.println(userId);
        //TODO 建表——T_USER_AUTHENTICATION 用户认证表  【ID,用户， 认证类型， 认证具体项, 认证时间， 认证状态】，总的认证状态是否要记录
        //TODO 数据定义——实名认证 RealNameAuth, 人脸识别 FaceAuth, 绑定银行卡 CardAuth
        return result;
    }

    /**
     * 实名认证
     *
     */
        @PostMapping(value = "identity/doRealNameAuth.do")
    public Map<String, Object> doRealNameAuth(
            @RequestParam("files") MultipartFile[] files,
            @RequestParam String name,
            @RequestParam String identityNo
    )
    {
        System.out.println(name);
        System.out.println(identityNo);
        System.out.println(files.length);
        //TODO 拦截——判断姓名与身份证号是否与存管库信息是否一致
        //TODO 将文件录入到文件服务器
        //TODO 将文件记录到数据库中
        //TODO 接口——调用实名认证接口
        //TODO 接口返回处理
        //身份认证
        return result;
    }

    /**
     * 人脸认证
     *
     */
    @PostMapping(value = "identity/doFaceAuth.do")
    public Map<String, Object> doFaceAuth(
            @RequestParam String userId,
            @RequestParam String isPass
    )
    {
        System.out.println(userId);
        System.out.println(isPass);
        //TODO 存储——将返回的结果修改数据库的状态
        return result;
    }

    /**
     * 绑定银行卡
     *
     */
    @PostMapping(value = "identity/doCardAuth.do")
    public Map<String, Object> doCardAuth(
            @RequestParam String userId,
            @RequestParam String cardNo
    )
    {
        System.out.println(userId);
        System.out.println(cardNo);
        //TODO 这个需要讨论下
        //身份认证
        return result;
    }


    /**
     * 查询个人资料状态
     *
     */
    @PostMapping(value = "person/queryInfoStatus.do")
    public Map<String, Object> queryInfoStatus(
            @RequestParam String userId
    )
    {
        System.out.println(userId);
        //TODO 查询状态
        return result;
    }


    /**
     * 更新个人资料信息状态
     *
     */
    @PostMapping(value = "person/updatePersonInfo.do")
    public Map<String, Object> updatePersonInfo(
            @RequestParam String userId
            //TODO 传入对象设计
    )
    {
        System.out.println(userId);
        //TODO 更新个人信息
        //TODO QQ格式验证，邮箱格式验证，必输入项验证，【字段比较多，开发注意细心】，这些地段数据库中的映射，看看有没有少
        return result;
    }

    /**
     * 更新单位信息状态
     *
     */
    @PostMapping(value = "person/updateUnitInfo.do")
    public Map<String, Object> updateUnitInfo(
            @RequestParam String userId
            //TODO 传入对象设计
    )
    {
        System.out.println(userId);
        //TODO 更新个人单位信息
        //TODO QQ格式验证，邮箱格式验证，必输入项验证，【字段比较多，开发注意细心】，这些地段数据库中的映射，看看有没有少
        return result;
    }


    /**
     * 更新联系人信息状态
     *
     */
    @PostMapping(value = "person/updateRelationInfo.do")
    public Map<String, Object> updateRelationInfo(
            @RequestParam String userId
            //TODO 传入对象设计
    )
    {
        System.out.println(userId);
        //TODO 更新个人单位信息
        //TODO QQ格式验证，邮箱格式验证，必输入项验证，【字段比较多，开发注意细心】，这些地段数据库中的映射，看看有没有少
        return result;
    }


    //TODO 查询认证状态   queryExternalAuthStatus
    //TODO 8项认证 具体的我这边还要讨论下
    //常用平台的 报告          【支付宝，淘宝，京东】
    //公积金 登录获取   社保    【公积金，社保】
    //学信网  运营商  人行征信 【学信网 手机认证】



    /**
     * 查询进件进度
     *
     */
    @PostMapping(value = "riskCamera/queryLoanProcess.do")
    public Map<String, Object> queryLoanProcess(
            @RequestParam String userId
            //TODO 传入对象设计
    ) {
        System.out.println(userId);
        //TODO 查询在读进件这个逻辑会变，要支持多笔进件
        return result;
    }

    /**
     * 个人中心修改
     *
     */
    @PostMapping(value = " trusteeAccount/myAccount.do")
    public Map<String, Object> myAccount(
            @RequestParam String userId
            //TODO 传入对象设计
    ) {
        System.out.println(userId);
        //TODO 还款计划这边需要调整
        //TODO 添加链接
        return result;
    }


    /**
     * 提交进件
     */
    @PostMapping(value = "riskCamera/submitCamera.do")
    public Map<String, Object> submitCamera(){
        //TODO 这边需要验证评分规则吧

        return result;
    }
}
