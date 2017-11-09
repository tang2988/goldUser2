package cn.jbit.entity;


public class OrderinformationConstant2 {

	/******************* paymentMethod ***************************/
	public enum PaymentMethod {
		/**
		 * 付款方式：10余额支付；20网银支付
		 */
		v10(10,"余额支付"),
		/**
		 * 付款方式：10余额支付；20网银支付
		 */
		v20(20,"网银支付") ;
		//PaymentMethod v10 = new PaymentMethod(10);
		
		int val;
		String desc;
		private PaymentMethod(int k0,String desc0){
			this.val = k0;
			this.desc = desc0;
		}
		public int getVal() {
			return val;
		}
		public void setVal(int val) {
			this.val = val;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		
	}
	/******************* paymentMethod ***************************/
}
