/*
 * Copyright (c) 2018-2020, Ripin Yan. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ins.platform.aggpay.trade.service;

import ins.platform.aggpay.trade.vo.GpRefundOrderVo;
import ins.platform.aggpay.trade.vo.GpTradeOrderVo;

/**
 * <p>
 * 交易服务类
 * </p>
 *
 * @author ripin
 * @since 2018-10-11
 */
public interface GpTradeService {

	/**
	 * scanPay(移动刷卡支付（被扫）)
	 *
	 * @Title: scanPay
	 * @Description: 
	 * @param tradeOrderVo
	 * @throws 
	 * @author Ripin Yan
	 * @return ins.platform.aggpay.trade.vo.GpTradeOrderVo
	 */
	GpTradeOrderVo scanPay(GpTradeOrderVo tradeOrderVo);

	/**
	 * prePay(H5支付（主扫）)
	 *
	 * @Title: prePay
	 * @Description: 
	 * @param tradeOrderVo
	 * @throws 
	 * @author Ripin Yan
	 * @return ins.platform.aggpay.trade.vo.GpTradeOrderVo
	 */
	GpTradeOrderVo prePay(GpTradeOrderVo tradeOrderVo);

	/**
	 * refund(退款)
	 *
	 * @Title: refund
	 * @Description:
	 * @param refundVo 退款订单
	 * @author Ripin Yan
	 * @return ins.platform.aggpay.trade.vo.GpRefundOrderVo
	 */
	GpRefundOrderVo refund(GpRefundOrderVo refundVo);

	/**
	 * 订单查询
	 *
	 * @param merchantId 商户号
	 * @param outTradeNo 外部交易号
	 * @return 交易订单信息
	 */
	GpTradeOrderVo payQuery(String merchantId, String outTradeNo);


	/**
	 * refundQuery(退款查询)
	 *
	 * @Title: refundQuery
	 * @Description:
	 * @param merchantId 商户号
	 * @param outTradeNo 退款外部交易号
	 * @author Ripin Yan
	 * @return ins.platform.aggpay.trade.vo.GpRefundOrderVo
	 */
	GpRefundOrderVo refundQuery(String merchantId, String outRefundNo);

	/**
	 * dynamicOrder(动态订单扫码支付接口)
	 *
	 * @Title: dynamicOrder
	 * @Description: 
	 * @param tradeOrderVo 订单vo
	 * @throws 
	 * @author Ripin Yan
	 * @return ins.platform.aggpay.trade.vo.GpTradeOrderVo
	 */
	GpTradeOrderVo dynamicOrder(GpTradeOrderVo tradeOrderVo);

}
