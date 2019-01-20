<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<head>
<meta charset="utf-8">
<title>Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<link href="/css/slider.css" rel="stylesheet" type="text/css" media="all"/>
<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script> 
<script type="text/javascript" src="/js/move-top.js"></script>
<script type="text/javascript" src="/js/easing.js"></script>
<script type="text/javascript" src="/js/startstop-slider.js"></script>
<script type="text/javascript" src="/js/regular.js"></script>
</head>
<body>
  <div class="wrap">
	<div class="header">
		<div class="headertop_desc">
			<div class="call">
				 <p><span>需要买房?</span> 请给我们 打电话: <span class="number">1-22-3456789</span></span></p>
			</div>
			<div class="account_desc">
				<ul>
					<li id="Register"><a href="#">Register</a></li>
					<li id="login"><a href="/sys/page/login">登录</a></li>
					<li id="outlogin" onclick="clicklogin('/sys/outlogin')">退出登录</li>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
		<div class="header_top">
			<div class="logo">
				<a href="index.html"><img src="/images/logo.png" alt="" /></a>
			</div>
			  <div class="cart">
			  	   <p>欢迎来到我们的网上买房！ <span>新房:</span><div id="dd" class="wrapper-dropdown-2"> 多多，价格优惠
			  	   	<ul class="dropdown">
							<li>you have no items in your Shopping cart</li>
					</ul></div></p>
			  </div>
			<script type="text/javascript">
			function DropDown(el) {
				this.dd = el;
				this.initEvents();
			}
			DropDown.prototype = {
				initEvents : function() {
					var obj = this;

					obj.dd.on('click', function(event){
						$(this).toggleClass('active');
						event.stopPropagation();
					});
				}
			}
			$(function() {

				var dd = new DropDown( $('#dd') );
				$(document).click(function() {
					// all dropdowns
					$('.wrapper-dropdown-2').removeClass('active');
				});
			});

		</script>
	 <div class="clear"></div>
  </div>
	<div class="header_bottom">
	     	<div class="menu">
	     		<ul>
			    	<li class="active"><a href="index.html">城市切换:</a></li>
			    	<li><a href="about.html">宁都</a></li>
			    	<li><a href="delivery.html">瑞金</a></li>
			    	<li><a href="news.html">于都</a></li>
			    	<li><a href="contact.html">赣州</a></li>
			    	<div class="clear"></div>
     			</ul>
	     	</div>
	     	<div class="search_box">
	     		<form>
	     			<input type="text" value="搜索" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '搜索';}"><input type="submit" value="">
	     		</form>
	     	</div>
	     	<div class="clear"></div>
	     </div>
	<div class="header_slide">
			<div class="header_bottom_left">
				<div class="categories">
				  <ul>
				  	<h3>分类</h3>
				      <li><a href="#">别墅</a></li>
				      <li><a href="#">小区</a></li>
				      <li><a href="#">商务办公-写字楼</a></li>
				      <li><a href="#">店铺</a></li>
				      <li><a href="#">商品房</a></li>
				      <li><a href="#">拆迁政改房</a></li>
				  </ul>
				</div>
	  	     </div>
					 <div class="header_bottom_right">
					 	 <div class="slider">
							 <div id="slider">
			                    <div id="mover">
			                    	<div id="slide-1" class="slide">
									 <div class="slider-img">
									     <a href="preview.html"><img src="/images/slide-1-image.jpg" alt="learn more" /></a>
									  </div>
						             	<div class="slider-text">
		                                 <h1>清仓大<br><span>甩卖</span></h1>
		                                 <h2>最高 20% 折扣</h2>
									   <div class="features_list">
									   	<h4>華豫公馆-知名的象征，来这里展现您的贵族气息</h4>
							            </div>
							             <a href="preview.html" class="button">现在去购房</a>
					                   </div>
									  <div class="clear"></div>
				                  </div>
						             	<div class="slide">
						             		<div class="slider-text">
		                                 <h1>清仓大<br><span>甩卖</span></h1>
		                                 <h2>最高 40% 折扣</h2>
									   <div class="features_list">
									   	<h4>了解我们难忘的服务</h4>
							            </div>
							             <a href="preview.html" class="button">现在去购房</a>
					                   </div>
						             	 <div class="slider-img">
									     <a href="preview.html"><img src="/images/slide-3-image.jpg" alt="learn more" /></a>
									  </div>
									  <div class="clear"></div>
				                  </div>
				                  <div class="slide">
					                  <div class="slider-img">
									     <a href="preview.html"><img src="/images/slide-2-image.jpg" alt="learn more" /></a>
									  </div>
									  <div class="slider-text">
		                                 <h1>清仓大<br><span>甩卖</span></h1>
		                                 <h2>最高 10% 折扣</h2>
									   <div class="features_list">
									   	<h4>宁都-清华名府小区，给您一个舒适、安心的家</h4>
							            </div>
							             <a href="preview.html" class="button">现在去购房</a>
					                   </div>
									  <div class="clear"></div>
				                  </div>
			                 </div>
		                </div>
					 <div class="clear"></div>
		         </div>
		      </div>
		   <div class="clear"></div>
		</div>
   </div>
   <div class="tlinks">Collect from <a href="http://www.cssmoban.com/" >网页模板</a></div>
 <div class="main">
    <div class="content">
    	<div class="content_top">
    		<div class="heading">
    		<h3>热销房</h3>
    		</div>
    		<div class="see">
    			<p><a href="#">查看更多</a></p>
    		</div>
    		<div class="clear"></div>
    	</div>
	      <div class="section group">
				<div class="grid_1_of_4 images_1_of_4">
					 <a href="preview.html"><img src="/images/feature-pic1.jpg" alt="" /></a>
					 <h2>Lorem Ipsum is simply </h2>
					<div class="price-details">
				       <div class="price-number">
							<p><span class="rupees">￥5000元/</span><span>m2</span></p>
					    </div>
					       		<div class="add-cart">
									<h4><a href="preview.html">抢购</a></h4>
							     </div>
							 <div class="clear"></div>
					</div>

				</div>
				<div class="grid_1_of_4 images_1_of_4">
					<a href="preview.html"><img src="/images/feature-pic1.jpg" alt="" /></a>
					 <h2>Lorem Ipsum is simply </h2>
					<div class="price-details">
				       <div class="price-number">
							<p><span class="rupees">￥5000元/</span><span>m2</span></p>
					    </div>
					       		<div class="add-cart">
									<h4><a href="preview.html">抢购</a></h4>
							     </div>
							 <div class="clear"></div>
					</div>

				</div>
				<div class="grid_1_of_4 images_1_of_4">
					<a href="preview.html"><img src="/images/feature-pic1.jpg" alt="" /></a>
					 <h2>Lorem Ipsum is simply </h2>
					 <div class="price-details">
				       <div class="price-number">
							<p><span class="rupees">￥5000元/</span><span>m2</span></p>
					    </div>
					       		<div class="add-cart">
									<h4><a href="preview.html">抢购</a></h4>
							     </div>
							 <div class="clear"></div>
					</div>
				</div>
				<div class="grid_1_of_4 images_1_of_4">
					<a href="preview.html"><img src="/images/feature-pic1.jpg" alt="" /></a>
					 <h2>Lorem Ipsum is simply </h2>
					<div class="price-details">
				       <div class="price-number">
							<p><span class="rupees">￥5000元/</span><span>m2</span></p>
					    </div>
					       		<div class="add-cart">
									<h4><a href="preview.html">抢购</a></h4>
							     </div>
							 <div class="clear"></div>
					</div>
				</div>
			</div>
			<div class="content_bottom">
    		<div class="heading">
    		<h3>安居房</h3>
    		</div>
    		<div class="see">
    			<p><a href="#">查看更多</a></p>
    		</div>
    		<div class="clear"></div>
    	</div>
			<div class="section group">
				<div class="grid_1_of_4 images_1_of_4">
					 <a href="preview.html"><img src="/images/feature-pic1.jpg" alt="" /></a>
					 <h2>Lorem Ipsum is simply </h2>
					<div class="price-details">
				       <div class="price-number">
							<p class="p-span-color"><span class="rupees">￥5000元/</span><span>m2</span></p>
					    </div>
					       		<div class="add-cart">
									<h4><a href="preview.html">Add to Cart</a></h4>
							     </div>
							 <div class="clear"></div>
					</div>
				</div>
				<div class="grid_1_of_4 images_1_of_4">
					<a href="preview.html"><img src="/images/feature-pic1.jpg" alt="" /></a>
					 <h2>Lorem Ipsum is simply </h2>
					 <div class="price-details">
				       <div class="price-number">
							<p><span class="rupees">￥5000元/</span><span>m2</span></p>
					    </div>
					       		<div class="add-cart">
									<h4><a href="preview.html">Add to Cart</a></h4>
							     </div>
							 <div class="clear"></div>
					</div>
				</div>
				<div class="grid_1_of_4 images_1_of_4">
					<a href="preview.html"><img src="/images/feature-pic1.jpg" alt="" /></a>
					 <h2>Lorem Ipsum is simply </h2>
					<div class="price-details">
				       <div class="price-number">
							<p><span class="rupees">￥5000元/</span><span>m2</span></p>
					    </div>
					       		<div class="add-cart">
									<h4><a href="preview.html">Add to Cart</a></h4>
							     </div>
							 <div class="clear"></div>
					</div>
				</div>
				<div class="grid_1_of_4 images_1_of_4">
				 <a href="preview.html"><img src="/images/feature-pic1.jpg" alt="" /></a>
					 <h2>Lorem Ipsum is simply </h2>
					 <div class="price-details">
				       <div class="price-number">
							<p class="p-span-color"><span class="rupees">￥5000元/</span><span>m2</span></p>
					    </div>
					       		<div class="add-cart">
									<h4><a href="preview.html">Add to Cart</a></h4>
							     </div>
							 <div class="clear"></div>
					</div>
				</div>
			</div>
    </div>
 </div>
</div>
   <div class="footer">
   	  <div class="wrap">
	     <div class="section group">
				<div class="col_1_of_4 span_1_of_4">
						<h4>Information</h4>
						<ul>
						<li><a href="about.html">About Us</a></li>
						<li><a href="contact.html">Customer Service</a></li>
						<li><a href="#">Advanced Search</a></li>
						<li><a href="delivery.html">Orders and Returns</a></li>
						<li><a href="contact.html">Contact Us</a></li>
						</ul>
					</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4>Why buy from us</h4>
						<ul>
						<li><a href="about.html">About Us</a></li>
						<li><a href="contact.html">Customer Service</a></li>
						<li><a href="#">Privacy Policy</a></li>
						<li><a href="contact.html">Site Map</a></li>
						<li><a href="#">Search Terms</a></li>
						</ul>
				</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4>My account</h4>
						<ul>
							<li><a href="contact.html">Sign In</a></li>
							<li><a href="index.html">View Cart</a></li>
							<li><a href="#">My Wishlist</a></li>
							<li><a href="#">Track My Order</a></li>
							<li><a href="contact.html">Help</a></li>
						</ul>
				</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4>Contact</h4>
						<ul>
							<li><span>+91-123-456789</span></li>
							<li><span>+00-123-000000</span></li>
						</ul>
						<div class="social-icons">
							<h4>Follow Us</h4>
					   		  <ul>
							      <li><a href="#" target="_blank"><img src="/images/facebook.png" alt="" /></a></li>
							      <li><a href="#" target="_blank"><img src="/images/twitter.png" alt="" /></a></li>
							      <li><a href="#" target="_blank"><img src="/images/skype.png" alt="" /> </a></li>
							      <li><a href="#" target="_blank"> <img src="/images/dribbble.png" alt="" /></a></li>
							      <li><a href="#" target="_blank"> <img src="/images/linkedin.png" alt="" /></a></li>
							      <div class="clear"></div>
						     </ul>
   	 					</div>
				</div>
			</div>
        </div>
        <div class="copy_right">
				<p>Copyright &copy;2018. Kanfang.com All Rights Reserved ICP备案号：赣ICP备05067210号-3</p>
				<p>公司名称：赣州市Kan房网络科技有限公司</p>
		   </div>
    </div>
    <script type="text/javascript">
        var accessToken = Cookies.get('accessToken');
        if(!isBlank(accessToken)){
            $("#login").hide();
            $("#outlogin").show();
		}else{
            $("#login").show();
            $("#outlogin").hide();
		}
		$(document).ready(function() {
			$().UItoTop({ easingType: 'easeOutQuart' });
            $.ajax({
                type: "GET",
                url: "/sys/article",
                dataType: "JSON",
                success: function(data){
                    if(data!=null&&data.code==200) {
                        $("#Register").html(data.msg);
					}
                }
            });
		})
		function clicklogin(url) {
			//退出登录
			var accessToken = Cookies.get('accessToken');
			//可以在这里做cookie的移除，这样旧的token就不会存储在cookie了。
			Cookies.set('accessToken', accessToken, { expires: -1 });
			//先清除redis
			$.ajax({
				type: "POST",
				url: url,
				headers: {
					"Content-Type": "application/json; charset=utf-8"
				},
				data:JSON.stringify(accessToken),
				dataType: "JSON",
				success: function(data){
					location.href = "/sys/page/login";
				}
			})
        }
	</script>
    <a href="#" id="toTop"><span id="toTopHover"> </span></a>

</body>
</html>

