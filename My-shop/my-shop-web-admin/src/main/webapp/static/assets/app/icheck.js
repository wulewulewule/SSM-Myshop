/**
 * 这是一个函数对象
 *var  Check = function(){

}();


 用来 初始化iCheck


 * **/
var  Check = function(){

    var _masterCheckbox;
    var _checkbox;

    /**
     * 私有方法，用来初始化iCheck
     */
    var handlerInitCheckbox = function(){

        // 激活 iCheck
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        });

        //获取控制端CHeckbox
        _masterCheckbox = $('input[type="checkbox"].minimal.icheck_master');
        //获取全部Checkbox集合
        _checkbox = $('input[type="checkbox"].minimal');


    };

    //checkbox全选功能
    var handlerCheckboxAll = function () {
        _masterCheckbox.on("ifClicked",function (e) {
            //console.log(e.target.checked);  false即为选中状态
            //console.log("hello");
            if(e.target.checked){
                //true为 未选中
                _checkbox.iCheck("uncheck");
            }
            else {
                //选中状态
                _checkbox.iCheck("check");
            }

        });
    };

    return {
        init:function () {
            handlerInitCheckbox();
            handlerCheckboxAll();
        },
        getCheckbox:function () {
            return _checkbox;

        }
    }
}();

   /* 导入这个函数直接生效*/
   $(document).ready(function () {
       Check.init();
   });

   /**
    * 到foot.jsp中添加js的路径
    * **/