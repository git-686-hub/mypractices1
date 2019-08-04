function show(){
	document.getElementById('demo').style.display='block';
	document.getElementById('demo').innerHTML=Date();
}
function showString(){
	var x = 5;
	var y = 6;
	var z = x+y;
	document.getElementById('demo').innerHTML='z的值是 : '+z;
}
function reset(){
	document.getElementById('demo').innerHTML='这里要显示什么呢？';
}
function print(){
	//document.getElementById('demo').innerHTML=6+9;
	//document.write(6+9);
	console.log("输出");
}