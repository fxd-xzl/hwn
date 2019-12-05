
//fxd:封装ajax

/**
 * ajax post request
 * @param {Object} url 请求地址
 * @param {Object} data 请求参数
 * @param {Object} success 成功回调
 * @param {Object} async 是否同步 false:同步 ture：异步
 */
function ajax_post(url,data,success,async){
	 ajax(url,data,"post",async,success)
}
 

/**
 * ajax get request
 * @param {Object} url 请求地址
 * @param {Object} data 请求参数
 * @param {Object} success 成功回调
 * @param {Object} async 是否同步 false:同步 ture：异步
 */
function ajax_get(url,data,success,async){
	 ajax(url,data,"get",async,success)
}

/**
 * ajax post 跨域 request
 * @param {Object} url 请求地址
 * @param {Object} data 请求参数
 * @param {Object} success 成功回调
 * @param {Object} async 是否同步 false:同步 ture：异步
 */
function ajax_cross(url,data,success,async){
	$.ajax({
		type:"post",
		url:url,
		async:async,
		data:data,
		dataType:"json",
		xhrFields:{
			withCredentials:true
		},
		crossDomain:true,
		success:success
	});
}

/**
 * jquery 的ajax
 * @param {Object} url
 * @param {Object} data
 * @param {Object} type
 * @param {Object} async
 * @param {Object} success
 */
function ajax(url,data,type,async,success){
	$.ajax({
		type:type,
		url:url,
		async:async,
		data:data,
		dataType:"json",
		success:success
	});
}

