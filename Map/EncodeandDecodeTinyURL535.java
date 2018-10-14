//https://leetcode.com/problems/encode-and-decode-tinyurl
package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EncodeandDecodeTinyURL535 {

	static Map<String, String> hm = new HashMap<String, String>();
	static String domain = "http://shubhamyeole.com/";

	public static void main(String[] args) {
		String s1 = "https://stackoverflow.com/questions/1389736/how-do-i-create-a-unique-id-in-java";
		String s2 = "https://www.facebook.com/dialog/share?app_id=1833670990199396&display=popup&href=https%3A%2F%2Fwww.lifewire.com%2Fhow-to-fix-my-ipad-is-frozen-1994537%3Futm_source%3Dfacebook%26utm_medium%3Dsocial%26utm_campaign%3Dshareurlbuttons&redirect_uri=https%3A%2F%2Fwww.lifewire.com%2FfacebookShareRedirect.htm";
		String s3 = "https://www.pinterest.com/pin/create/button/?url=https%3A%2F%2Fwww.lifewire.com%2Fhow-to-fix-my-ipad-is-frozen-1994537%3Futm_source%3Dpinterest%26utm_medium%3Dsocial%26utm_campaign%3Dshareurlbuttons&description=How+to+Fix+a+Frozen+iPad+Without+Ripping+Your+Hair+Out&media=https%3A%2F%2Fwww.lifewire.com%2Fthmb%2FyUKZC7UL-u_wFKafoKaQJ-CUr3Y%3D%2F750x0%2FiStock-836196274-ipad-frozen-5a63566abeba33003619f11c.jpg";
		String s4 = "https://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/";
		String s5 = "https://algorithms.tutorialhorizon.com/reverse-a-linked-list/";

		System.out.printf("S1: %s\nENCODE: %s\nDECODE: %s\n\n", s1, encodeUrls(s1), decodeUrl(encodeUrls(s1)));
		System.out.printf("S2: %s\nENCODE: %s\nDECODE: %s\n\n", s2, encodeUrls(s2), decodeUrl(encodeUrls(s2)));
		System.out.printf("S3: %s\nENCODE: %s\nDECODE: %s\n\n", s3, encodeUrls(s3), decodeUrl(encodeUrls(s3)));
		System.out.printf("S4: %s\nENCODE: %s\nDECODE: %s\n\n", s4, encodeUrls(s4), decodeUrl(encodeUrls(s4)));
		System.out.printf("S5: %s\nENCODE: %s\nDECODE: %s\n\n", s5, encodeUrls(s5), decodeUrl(encodeUrls(s5)));

	}

	private static String decodeUrl(String encoded) {
		return hm.get(encoded.replace(domain, ""));
	}

	private static String encodeUrls(String urls) {

		String uuid = UUID.randomUUID().toString();

		hm.put(uuid, urls);

		return domain.concat(uuid);
	}

}
