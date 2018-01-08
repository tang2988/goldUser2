<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
* {
	margin: 0;
	padding: 0
}

ul {
	list-style: none;
}

.tab {
	width: 300px;
	margin: 0 auto;
}

.tab .tab_menu {
	border: 1px solid #000000;
	height: 30px;
	width: 700px;
}

.tab .tab_menu ul li {
	float: left;
	width: 99px;
	text-align: center;
	line-height: 30px;
	border-right: 1px #333333 solid;
}

.tab .tab_menu ul li:last-child {
	border-right: none;
	width: 100px;
}

.tab .tab_menu ul li.on {
	background: #999;
}

.tab .tab_box>div {
	display: none; //
	将三个内容框架全隐藏，通过下面的: first-child属性只将第一个框架内容显示出来
}

.tab .tab_box>div:first-child {
	display: block;
}

.xxh {
	list-style: none;
	width: auto;
	text-align: center;
}
</style>
</head>

<body>
	<form action="ordersteadyprofit/OrderAdd" method="post">
		<table width=>
			<tr>
				<td><%@include file="/WEB-INF/Jsp/include/Daohang.jsp"%></td>

			</tr>
			<input type="hidden" name="productId" value="${lossVo.productId}" />
			<tr>
				<td></td>
			</tr>

			<tr>
				<td>
					<!-- 内容 -->


					<table>

						<tr>
							<!-- 123 -->

							<td>
								<table width="100%">
									<tr>
										<td style="font-size: 30px;">${lossVo.productName}</td>
										<td>波动型产品</td>
										<td>产品介绍</td>

									</tr>
								</table>
							</td>

						</tr>
						<!-- 结束 -->

						<tr>
							<td>
								<table>
									<tr>
										<!-- 345 -->
										<td>
											<table width="1000px">
												<tr>
													<td>${lossVo.expectedAnnualizedInterestRate}%+${lossVo.activityPlusInterest}%</td>
													<td>${lossVo.productDeadline}天</td>
													<td>${lossVo.sumofMoneyPurchaseddecimal}元</td>

												</tr>
												<tr>
													<td>预期年化金息 活动加息</td>
													<td>期限</td>
													<td>起购金额</td>
												</tr>
												<tr>
													<td><img src="img/wenzi.png" alt="找不到" /></td>
													<td>

														<table>
															<tr>
																<td><%-- ${PriceMoney.price} --%></td>
															</tr>
															<tr>
																<td>实时金价（元/克）</td>
															</tr>

															<tr>
																<td>按金额购买</td>
																<td>按克重购买</td>
															</tr>
															<tr>
																<td>购买金额</td>
																<br />

															</tr>
															<tr>
																<td><input type="text" name="totalOrder" />元</td>
															</tr>
															<tr>
																<td><input type="submit" value="立刻购买" /></td>
															</tr>

															<tr>
																<td>黄金克重0.362克</td>
															</tr>
														</table>

													</td>
												</tr>


											</table>
										</td>

									</tr>
									<!-- 结束 -->
									<tr>
										<td><table>
												<tr>
													<td><div class="tab">
															<div class="tab_menu">
																<ul>
																	<li class="on">产品介绍</li>
																	<li>购买记录</li>
																	<li>常见问题</li>
																</ul>
															</div>
															<div class="tab_box">
																<div>
																	<img src="img/chanpingjieshao.png" alt="找不到图片"
																		width="695px" />
																</div>

																<div>
																	<table>
																		<tbody>
																			<tr>
																				<th>用户</th>
																				<th>购买时间</th>
																				<th>购买克重</th>
																			</tr>
																			<tr>
																				<td>xxh</td>
																				<td>2017-11-11</td>
																				<td>10克</td>
																			</tr>
																		</tbody>

																	</table>
																</div>

																<div>
																	<dl style="width: 695px">
																		<dt>1.什么是定期金？</dt>
																		<dd>定期金是一款在固定期限内能获得较高收益的产品
																			，同时能享受黄金在该期限内的浮动收益，投资人将购买的黄金以定期存管方式“存”在买金呗平台 。</dd>
																		<br />
																	</dl>

																	<dl style="width: 695px">
																		<dt>2.购买后可提前赎回吗？</dt>
																		<dd>定期金中途不可提前赎回或转让，到期后自动转入金荷包继续生息或可进行提金、卖金等操作。（注：到期日如遇非交易日，则顺延至交易日转入金荷包）</dd>
																		<br />
																	</dl>

																	<dl style="width: 695px">
																		<dt>4.什么时间段可以购买？</dt>
																		<dd>买金呗平台交易时间为：工作日9：00 -
																			24:00，非交易时间段黄金产品不可买卖，投资类（看涨跌）产品及饰品类产品不受交易时间限制。</dd>
																		<br />
																	</dl>

																	<dl style="width: 695px">
																		<dt>3.定期金利息如何计算?</dt>
																		<dd>当日利息=
																			当天休市报价x购买克重x预期年化金息/365，当每日计息不足一分时，系统不会分配收益，且不会累积。</dd>
																		<br />
																	</dl>

																</div>

															</div>
														</div></td>
												</tr>

											</table></td>

									</tr>



									<tr>
										<td><img width="97%" src="img/Yejiao.png" /></td>
									</tr>



								</table>
								</form>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$(".tab_menu ul li").click(function() {
			$(this).addClass("on").siblings().removeClass("on"); //切换选中的按钮高亮状态
			var index = $(this).index(); //获取被按下按钮的索引值，需要注意index是从0开始的
			$(".tab_box > div").eq(index).show().siblings().hide(); //在按钮选中时在下面显示相应的内容，同时隐藏不需要的框架内容
		});
	});
</script>
</html>
