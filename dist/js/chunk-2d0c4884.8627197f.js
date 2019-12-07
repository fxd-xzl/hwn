(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0c4884"],{"3add":function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("Form",{ref:"formValidate",attrs:{model:e.formValidate,rules:e.ruleValidate,"label-width":80}},[a("FormItem",{attrs:{label:"Name",prop:"name"}},[a("Input",{attrs:{placeholder:"Enter your name"},model:{value:e.formValidate.name,callback:function(t){e.$set(e.formValidate,"name",t)},expression:"formValidate.name"}})],1),a("FormItem",{attrs:{label:"E-mail",prop:"mail"}},[a("Input",{attrs:{placeholder:"Enter your e-mail"},model:{value:e.formValidate.mail,callback:function(t){e.$set(e.formValidate,"mail",t)},expression:"formValidate.mail"}})],1),a("FormItem",{attrs:{label:"City",prop:"city"}},[a("Select",{attrs:{placeholder:"Select your city"},model:{value:e.formValidate.city,callback:function(t){e.$set(e.formValidate,"city",t)},expression:"formValidate.city"}},[a("Option",{attrs:{value:"beijing"}},[e._v("New York")]),a("Option",{attrs:{value:"shanghai"}},[e._v("London")]),a("Option",{attrs:{value:"shenzhen"}},[e._v("Sydney")])],1)],1),a("FormItem",{attrs:{label:"Date"}},[a("Row",[a("Col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"date"}},[a("DatePicker",{attrs:{type:"date",placeholder:"Select date"},model:{value:e.formValidate.date,callback:function(t){e.$set(e.formValidate,"date",t)},expression:"formValidate.date"}})],1)],1),a("Col",{staticStyle:{"text-align":"center"},attrs:{span:"2"}},[e._v("-")]),a("Col",{attrs:{span:"11"}},[a("FormItem",{attrs:{prop:"time"}},[a("TimePicker",{attrs:{type:"time",placeholder:"Select time"},model:{value:e.formValidate.time,callback:function(t){e.$set(e.formValidate,"time",t)},expression:"formValidate.time"}})],1)],1)],1)],1),a("FormItem",{attrs:{label:"Gender",prop:"gender"}},[a("RadioGroup",{model:{value:e.formValidate.gender,callback:function(t){e.$set(e.formValidate,"gender",t)},expression:"formValidate.gender"}},[a("Radio",{attrs:{label:"male"}},[e._v("Male")]),a("Radio",{attrs:{label:"female"}},[e._v("Female")])],1)],1),a("FormItem",{attrs:{label:"Hobby",prop:"interest"}},[a("CheckboxGroup",{model:{value:e.formValidate.interest,callback:function(t){e.$set(e.formValidate,"interest",t)},expression:"formValidate.interest"}},[a("Checkbox",{attrs:{label:"Eat"}}),a("Checkbox",{attrs:{label:"Sleep"}}),a("Checkbox",{attrs:{label:"Run"}}),a("Checkbox",{attrs:{label:"Movie"}})],1)],1),a("FormItem",{attrs:{label:"Desc",prop:"desc"}},[a("Input",{attrs:{type:"textarea",autosize:{minRows:2,maxRows:5},placeholder:"Enter something..."},model:{value:e.formValidate.desc,callback:function(t){e.$set(e.formValidate,"desc",t)},expression:"formValidate.desc"}})],1),a("FormItem",[a("Button",{attrs:{type:"primary"},on:{click:function(t){return e.handleSubmit("formValidate")}}},[e._v("Submit")]),a("Button",{staticStyle:{"margin-left":"8px"},on:{click:function(t){return e.handleReset("formValidate")}}},[e._v("Reset")])],1)],1)},l=[],i={data:function(){return{formValidate:{name:"",mail:"",city:"",gender:"",interest:[],date:"",time:"",desc:""},ruleValidate:{name:[{required:!0,message:"The name cannot be empty",trigger:"blur"}],mail:[{required:!0,message:"Mailbox cannot be empty",trigger:"blur"},{type:"email",message:"Incorrect email format",trigger:"blur"}],city:[{required:!0,message:"Please select the city",trigger:"change"}],gender:[{required:!0,message:"Please select gender",trigger:"change"}],interest:[{required:!0,type:"array",min:1,message:"Choose at least one hobby",trigger:"change"},{type:"array",max:2,message:"Choose two hobbies at best",trigger:"change"}],date:[{required:!0,type:"date",message:"Please select the date",trigger:"change"}],time:[{required:!0,type:"string",message:"Please select time",trigger:"change"}],desc:[{required:!0,message:"Please enter a personal introduction",trigger:"blur"},{type:"string",min:20,message:"Introduce no less than 20 words",trigger:"blur"}]}}},methods:{handleSubmit:function(e){var t=this;this.$refs[e].validate((function(e){e?t.$Message.success("Success!"):t.$Message.error("Fail!")}))},handleReset:function(e){this.$refs[e].resetFields()}}},s=i,o=a("2877"),n=Object(o["a"])(s,r,l,!1,null,null,null);t["default"]=n.exports}}]);
//# sourceMappingURL=chunk-2d0c4884.8627197f.js.map