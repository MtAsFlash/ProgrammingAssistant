package  {
	
	import flash.display.MovieClip;
	import flash.events.KeyboardEvent;
	import flash.events.TimerEvent;
	import flash.text.engine.TextRotation;
	import flash.utils.Timer;
	
	
	public class Mian extends MovieClip {
		private var man:MovieClip;
		private var myTime:Timer;
		private var state:String = "right";
		private var seep:int;
		private var losp:MovieClip;
		private var bread:MovieClip=null;
		private var manArr:Array;
		private var weibaba:MovieClip;
		private var mun:int = 0;
		//控制移动速度
		private var mytimering:int=200;
		
		private var weibaArr:Array;
		//动态文字
		private var mytext:MovieClip;
		
		public function Mian() {
			//积分初始化位置
			mytext = new textr();
			mytext.x = 380;
			mytext.y = 440;
			addChild(mytext);
			
		    
			//初始化主角位置
			man = new manr();
			man.x = 0;
			man.y = 22;
			addChildAt(man,3);
			
			//初始化主角数组
			manArr = new Array();
			manArr[0] = man;
			
			//尾巴数组
		    weibaArr = new Array;
			
			seep = man.width;
			//调用foot函数
			//添加食物
			foot();
			//计时器
			myTime = new Timer(mytimering);
			myTime.addEventListener(TimerEvent.TIMER, TimerUp);
			//开始计时
			myTime.start();
			//键盘事件侦听器
			stage.addEventListener(KeyboardEvent.KEY_DOWN, zouqi);
			stage.addEventListener(KeyboardEvent.KEY_UP, huanyuan);
		}
		//时间函数
		private  function TimerUp(e:TimerEvent):void {
			//
			trace(man.x+","+man.y);
			//如果吃到食物
         	if (manArr[0].hitTestObject(bread.child_ShiWu)) {
				//移除原来的食物
				removeChild(bread);
				//添加新的食物
				foot();
				//调用weibanixi函数
				//添加尾巴
				weibanixi(man.x, man.y);
				//mum递加1
				//控制数组
				mun++;
				//更换积分元件的动态文字
				mytext.txt.text = manArr.length.toString();//获取manArr长度，并转化为字符串
				//在数组元素manArr[mun]添加尾巴影片剪辑
				manArr[mun] = weibaba;
				
				//trace(manArr.length.toString());
				
				//添加延迟
				/*
				if (manArr.length> 5) {
			         myTime.delay = 100;
				}
				if (manArr.length > 10) {
					myTime.delay = 50;
				}
				if (manArr.length > 15) {
					myTime.delay = 20;
				}
				if (manArr.length > 20) {
					myTime.delay = 10;
				}
				*/
			}
			//如果存在尾巴
			if (weibaba != null) {
				for (var i:int = manArr.length - 1; i > 0; i-- ){
					//尾巴移动到上一个尾巴位置
					 manArr[i].x = manArr[i - 1].x;
					 manArr[i].y = manArr[i - 1].y;
					
					//添加头尾碰撞
					if(i>=5)
					{
						if(manArr[0].hitTestObject(manArr[i].child_One))
						{
							myTime.stop();
							losp = new shibai();
							losp.x = (stage.stageWidth - losp.width) / 2;
							losp.y = (stage.stageHeight - losp.height) / 2;
							stage.removeEventListener(KeyboardEvent.KEY_DOWN, zouqi);
							stage.removeEventListener(KeyboardEvent.KEY_UP, huanyuan);
							addChildAt(losp, 3);
						}
					}
					
				}
			}
			//移动主角
	     	if (state == "up") man.y -= seep;
			if (state=="below") man.y += seep;
			if (state=="left") man.x -= seep;
			if(state=="right") man.x += seep;

			//可穿墙
			if (man.x > stage.stageWidth - man.width / 2)
			{
				man.x = 0;
			}
			else if( man.x < -man.width / 2)
			{
				man.x = stage.stageWidth;
			}
			if(man.y> stage.stageHeight - man.height / 2)
			{
				man.y = 0;
			}
			else if(man.y < -man.height / 2)
			{
				man.y = stage.stageHeight;
			}
			//如果碰壁，游戏结束
			/*
			if (man.x > stage.stageWidth || man.x<-1 || man.y>stage.stageHeight || man.y<-1) {
				myTime.stop();
				losp = new shibai();
				losp.x = (stage.stageWidth - losp.width) / 2;
				losp.y = (stage.stageHeight - losp.height) / 2;
				stage.removeEventListener(KeyboardEvent.KEY_DOWN, zouqi);
				stage.removeEventListener(KeyboardEvent.KEY_UP, huanyuan);
				addChildAt(losp, 3);
			}
			*/
		}
		//添加食物函数
		private function foot():void {
			bread = new shiwu();
			bread.x = int(Math.random() * (stage.stageWidth)/22)*22 ;
			bread.y = int(Math.random () * (stage.stageHeight-22) / 22) * 22;
			addChildAt(bread,2);
		}
		//添加尾巴函数
		//位置在x:manx,y:many
		private function weibanixi(manx:int,many:int):void {
			
			weibaba = new weiba();
			addChildAt(weibaba,2);
			//addChild(snake);
		}
		//键盘按下事件函数	
		private function zouqi(e:KeyboardEvent):void {
			//trace(e.keyCode);
			switch(e.keyCode) {
				case 38:
				         // man.y -= seep;
						if(state != "below")
						{
						  state = "up";
						}
						  break;
				case 40:
				        // man.y += seep;
						if(state != "up")
						{
						 state = "below";
						}
					     
						  break;
				case 37:
				         //man.x -= seep;
						if(state != "right")
						{
						   state = "left";
						}
						
						   break;
				case 39:
				        // man.x += seep;
						if(state != "left")
						{
						  state = "right";
						}
					    
						 break;
				default:   
				         break;
			}
			
		}
		private function huanyuan(e:KeyboardEvent):void {
		}
	}
	
}
