
public class Test {
	public static void main(String[]args){

		Person taro = new Person();
			taro.name= "山田太郎";
			taro.age = 20;
			taro.phoneNumber = "1-1";
			taro.address = "東京";
				System.out.println(taro.name);
				System.out.println(taro.age);
				System.out.println(taro.phoneNumber);
				System.out.println(taro.address);
				taro.talk();
				taro.walk();
				taro.run();


		Person jiro = new Person();
			jiro.name = "木村次郎";
			jiro.age = 18;
			jiro.phoneNumber = "2-2";
			jiro.address = "埼玉";
				System.out.println(jiro.name);
				System.out.println(jiro.age);
				System.out.println(jiro.phoneNumber);
				System.out.println(jiro.address);
				jiro.talk();
				jiro.walk();
				jiro.run();

		Person hanako = new Person();
			hanako.name = "鈴木花子";
			hanako.age = 16;
			hanako.phoneNumber = "3-3";
			hanako.address = "千葉";
				System.out.println(hanako.name);
				System.out.println(hanako.age);
				System.out.println(hanako.phoneNumber);
				System.out.println(hanako.address);
				hanako.talk();
				hanako.walk();
				hanako.run();

		Person watashi = new Person();
			watashi.name = "野田栞";
			watashi.age = 28;
			watashi.phoneNumber = "4-4";
			watashi.address = "神奈川";
				System.out.println(watashi.name);
				System.out.println(watashi.age);
				System.out.println(watashi.phoneNumber);
				System.out.println(watashi.address);
				watashi.talk();
				watashi.walk();
				watashi.run();

		Person aibo = new Person();
			aibo.name = "aibo";
				aibo.talk();
				aibo.walk();
				aibo.run();

		Person asimo = new Person();
			asimo.name = "asimo";
				asimo.talk();
				asimo.walk();
				asimo.run();

		Person pepper = new Person();
			pepper.name = "pepper";
				pepper.talk();
				pepper.walk();
				pepper.run();


	}
}
