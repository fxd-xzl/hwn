(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d21022a"],{b732:function(t,e,o){"use strict";o.r(e);var a=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",[o("Row",{attrs:{gutter:20}},[o("Col",{attrs:{lg:4,md:8}},[o("Input",{staticClass:"input-width",attrs:{placeholder:"部门名称"},model:{value:t.departmentName,callback:function(e){t.departmentName=e},expression:"departmentName"}})],1),o("Col",{attrs:{lg:4,md:8}},[o("Button",{attrs:{type:"success"}},[o("Icon",{attrs:{type:"md-search"}}),t._v("查询 ")],1)],1)],1),o("br"),o("Row",[o("Button",{attrs:{type:"success"},on:{click:function(e){t.mgrModal=!0}}},[o("Icon",{attrs:{type:"md-add"}}),t._v("添加 ")],1),o("Button",{staticClass:"margin-left",attrs:{type:"error"}},[o("Icon",{attrs:{type:"md-close"}}),t._v("删除 ")],1)],1),o("br"),o("Table",{attrs:{columns:t.column1,data:t.data1}}),o("br"),o("Page",{attrs:{total:100}}),o("Modal",{attrs:{title:"部门管理"},model:{value:t.mgrModal,callback:function(e){t.mgrModal=e},expression:"mgrModal"}},[o("Form",{ref:"formItem",attrs:{model:t.formItem}},[o("FormItem",{attrs:{label:"部门编号"}},[o("Input",{attrs:{clearable:""},model:{value:t.formItem.no,callback:function(e){t.$set(t.formItem,"no",e)},expression:"formItem.no"}})],1),o("FormItem",{attrs:{label:"部门名称"}},[o("Input",{attrs:{clearable:""},model:{value:t.formItem.no,callback:function(e){t.$set(t.formItem,"no",e)},expression:"formItem.no"}})],1),o("FormItem",{attrs:{label:"部门类型"}},[o("Input",{attrs:{clearable:""},model:{value:t.formItem.no,callback:function(e){t.$set(t.formItem,"no",e)},expression:"formItem.no"}})],1),o("FormItem",{attrs:{label:"负责人"}},[o("Input",{attrs:{clearable:""},model:{value:t.formItem.no,callback:function(e){t.$set(t.formItem,"no",e)},expression:"formItem.no"}})],1),o("FormItem",{attrs:{label:"联系电话"}},[o("Input",{attrs:{clearable:""},model:{value:t.formItem.no,callback:function(e){t.$set(t.formItem,"no",e)},expression:"formItem.no"}})],1)],1),o("div",{attrs:{slot:"footer"},slot:"footer"},[o("Button",{on:{click:function(e){t.mgrModal=!1}}},[t._v("关闭")]),o("Button",{attrs:{type:"success"}},[t._v("保存")])],1)],1)],1)},r=[],l={name:"DepartmentMgr",data:function(){var t=this;return{departmentName:"",mgrModal:!1,formItem:{no:""},column1:[{key:"select",type:"selection",width:60},{key:"no",title:"部门编号"},{title:"部门名称"},{title:"部门类型"},{title:"负责人"},{title:"联系电话"},{title:"所属机构"},{title:"修改",width:100,render:function(e){return e("a",{on:{click:function(){t.mgrModal=!0}}},[e("Icon",{props:{type:"md-create",size:24}})])}}],data1:[{no:"aaa"}]}},methods:{}},n=l,m=o("2877"),s=Object(m["a"])(n,a,r,!1,null,null,null);e["default"]=s.exports}}]);
//# sourceMappingURL=chunk-2d21022a.6527bb7d.js.map