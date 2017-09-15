package com.bwie.weixin.test;

import com.bwie.weixin.util.MenuUtil;

/**
 * @function
 * @author 王治
 * @date 2017年6月20日
 */
public class JsonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 查询菜单
		String selectMenu = MenuUtil.selectMenu(
				"v7VICU_E5WYYoC5-PTx2XY6YGJsfV0B5TLDdTe87_uYFjNqh4SUJXGz__nqlXekxpUF5RnZIQoraZdG--P98I-xObP6vTiDWGAQTGsFxdtvdUCHJaQuw9kl5kzOyK0NIWFRaABAJSE");
		System.out.println(selectMenu);

		// 删除菜单
		String deleteMenu = MenuUtil.deleteMenu(
				"v7VICU_E5WYYoC5-PTx2XY6YGJsfV0B5TLDdTe87_uYFjNqh4SUJXGz__nqlXekxpUF5RnZIQoraZdG--P98I-xObP6vTiDWGAQTGsFxdtvdUCHJaQuw9kl5kzOyK0NIWFRaABAJSE");
		System.out.println(deleteMenu);
	}

}
