/**
 * Created on 22 Dec 2018 by happygirlzt
 *
 * LeetCode #535. Encode and Decode TinyURL
 *
 */

public class Codec {
    private Map<String, String> index = new HashMap<>();  // key longurl
    private Map<String, String> reversed = new HashMap<>();  // longurl key
    static final String BASE_HOST = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (reversed.containsKey(longUrl)) {
            return BASE_HOST + reversed.get(longUrl);
        }
        String candidates = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        String key = null;
        while (true) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int r = (int) (Math.random() * candidates.length());
                sb.append(candidates.charAt(r));
            }
            key = sb.toString();

            if (!index.containsKey(key)) break;
        }

        index.put(key, longUrl);
        reversed.put(longUrl, key);
        return BASE_HOST + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return index.get(shortUrl.replace(BASE_HOST, ""));
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
