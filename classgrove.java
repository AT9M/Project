import java.awt.Color;
import java.io.IOException;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
//import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;



public class classgrove extends Thread{
	static char initRegisterArray[][] = {	// Initial Gesture
	    {0xEF,0x00},
		{0x32,0x29},
		{0x33,0x01},
		{0x34,0x00},
		{0x35,0x01},
		{0x36,0x00},
		{0x37,0x07},
		{0x38,0x17},
		{0x39,0x06},
		{0x3A,0x12},
		{0x3F,0x00},
		{0x40,0x02},
		{0x41,0xFF},
		{0x42,0x01},
		{0x46,0x2D},
		{0x47,0x0F},
		{0x48,0x3C},
		{0x49,0x00},
		{0x4A,0x1E},
		{0x4B,0x00},
		{0x4C,0x20},
		{0x4D,0x00},
		{0x4E,0x1A},
		{0x4F,0x14},
		{0x50,0x00},
		{0x51,0x10},
		{0x52,0x00},
		{0x5C,0x02},
		{0x5D,0x00},
		{0x5E,0x10},
		{0x5F,0x3F},
		{0x60,0x27},
		{0x61,0x28},
		{0x62,0x00},
		{0x63,0x03},
		{0x64,0xF7},
		{0x65,0x03},
		{0x66,0xD9},
		{0x67,0x03},
		{0x68,0x01},
		{0x69,0xC8},
		{0x6A,0x40},
		{0x6D,0x04},
		{0x6E,0x00},
		{0x6F,0x00},
		{0x70,0x80},
		{0x71,0x00},
		{0x72,0x00},
		{0x73,0x00},
		{0x74,0xF0},
		{0x75,0x00},
		{0x80,0x42},
		{0x81,0x44},
		{0x82,0x04},
		{0x83,0x20},
		{0x84,0x20},
		{0x85,0x00},
		{0x86,0x10},
		{0x87,0x00},
		{0x88,0x05},
		{0x89,0x18},
		{0x8A,0x10},
		{0x8B,0x01},
		{0x8C,0x37},
		{0x8D,0x00},
		{0x8E,0xF0},
		{0x8F,0x81},
		{0x90,0x06},
		{0x91,0x06},
		{0x92,0x1E},
		{0x93,0x0D},
		{0x94,0x0A},
		{0x95,0x0A},
		{0x96,0x0C},
		{0x97,0x05},
		{0x98,0x0A},
		{0x99,0x41},
		{0x9A,0x14},
		{0x9B,0x0A},
		{0x9C,0x3F},
		{0x9D,0x33},
		{0x9E,0xAE},
		{0x9F,0xF9},
		{0xA0,0x48},
		{0xA1,0x13},
		{0xA2,0x10},
		{0xA3,0x08},
		{0xA4,0x30},
		{0xA5,0x19},
		{0xA6,0x10},
		{0xA7,0x08},
		{0xA8,0x24},
		{0xA9,0x04},
		{0xAA,0x1E},
		{0xAB,0x1E},
		{0xCC,0x19},
		{0xCD,0x0B},
		{0xCE,0x13},
		{0xCF,0x64},
		{0xD0,0x21},
		{0xD1,0x0F},
		{0xD2,0x88},
		{0xE0,0x01},
		{0xE1,0x04},
		{0xE2,0x41},
		{0xE3,0xD6},
		{0xE4,0x00},
		{0xE5,0x0C},
		{0xE6,0x0A},
		{0xE7,0x00},
		{0xE8,0x00},
		{0xE9,0x00},
		{0xEE,0x07},
		{0xEF,0x01},
		{0x00,0x1E},
		{0x01,0x1E},
		{0x02,0x0F},
		{0x03,0x10},
		{0x04,0x02},
		{0x05,0x00},
		{0x06,0xB0},
		{0x07,0x04},
		{0x08,0x0D},
		{0x09,0x0E},
		{0x0A,0x9C},
		{0x0B,0x04},
		{0x0C,0x05},
		{0x0D,0x0F},
		{0x0E,0x02},
		{0x0F,0x12},
		{0x10,0x02},
		{0x11,0x02},
		{0x12,0x00},
		{0x13,0x01},
		{0x14,0x05},
		{0x15,0x07},
		{0x16,0x05},
		{0x17,0x07},
		{0x18,0x01},
		{0x19,0x04},
		{0x1A,0x05},
		{0x1B,0x0C},
		{0x1C,0x2A},
		{0x1D,0x01},
		{0x1E,0x00},
		{0x21,0x00},
		{0x22,0x00},
		{0x23,0x00},
		{0x25,0x01},
		{0x26,0x00},
		{0x27,0x39},
		{0x28,0x7F},
		{0x29,0x08},
		{0x30,0x03},
		{0x31,0x00},
		{0x32,0x1A},
		{0x33,0x1A},
		{0x34,0x07},
		{0x35,0x07},
		{0x36,0x01},
		{0x37,0xFF},
		{0x38,0x36},
		{0x39,0x07},
		{0x3A,0x00},
		{0x3E,0xFF},
		{0x3F,0x00},
		{0x40,0x77},
		{0x41,0x40},
		{0x42,0x00},
		{0x43,0x30},
		{0x44,0xA0},
		{0x45,0x5C},
		{0x46,0x00},
		{0x47,0x00},
		{0x48,0x58},
		{0x4A,0x1E},
		{0x4B,0x1E},
		{0x4C,0x00},
		{0x4D,0x00},
		{0x4E,0xA0},
		{0x4F,0x80},
		{0x50,0x00},
		{0x51,0x00},
		{0x52,0x00},
		{0x53,0x00},
		{0x54,0x00},
		{0x57,0x80},
		{0x59,0x10},
		{0x5A,0x08},
		{0x5B,0x94},
		{0x5C,0xE8},
		{0x5D,0x08},
		{0x5E,0x3D},
		{0x5F,0x99},
		{0x60,0x45},
		{0x61,0x40},
		{0x63,0x2D},
		{0x64,0x02},
		{0x65,0x96},
		{0x66,0x00},
		{0x67,0x97},
		{0x68,0x01},
		{0x69,0xCD},
		{0x6A,0x01},
		{0x6B,0xB0},
		{0x6C,0x04},
		{0x6D,0x2C},
		{0x6E,0x01},
		{0x6F,0x32},
		{0x71,0x00},
		{0x72,0x01},
		{0x73,0x35},
		{0x74,0x00},
		{0x75,0x33},
		{0x76,0x31},
		{0x77,0x01},
		{0x7C,0x84},
		{0x7D,0x03},
		{0x7E,0x01},
	};





public static I2CBus bus;
public static byte PAJ7620_VAL (int val,int maskbit){ return (byte)(val << maskbit); }
private static I2CDevice device;
public final static byte BANK0 =0;
public final static byte BANK1 =1;
public final static byte PAJ7620_REGITER_BANK_SEL=(byte) (0x00 + 0xEF);
public final static byte PAJ7620_BANK0= PAJ7620_VAL (0x00,0x00);
public final static byte PAJ7620_BANK1= PAJ7620_VAL(1,0);

public static byte data0[] = new byte[1];
public static byte data1[] = new byte[1];

public static byte addcap = 0x73;





Grove IHM1;
public classgrove(Grove IHM) {
	
IHM1=IHM;
		
		//try {
		
			bus = I2CFactory.getInstance(I2CBus.BUS_1);
			device = bus.getDevice(addcap);
			paj7620SelectBank(BANK0);  //gesture flage reg in Bank0
			device.write((byte)(0x00));
device.read( data0 ,0x00, 1);
device.write((byte) 0x01);
device.read(data1,0,1);
if ( (data0[0] != 0x20 ) || (data1[0] != 0x76) )
	{
		System.out.println("fail.");
		System.exit(0);
	}
	if ( data0[0]  == 0x20 )
	{
		System.out.println("wake-up finish.");
	}

/*for(int i=0 ; i<initRegisterArray.length ; i++)
{
device.write(initRegisterArray[i][0],initRegisterArray[i][1]);
paj7620SelectBank(BANK0);
}
		} catch (IOException e) {
		
			e.printStackTrace();
		
		}*/
	
	
}
	


//public static int pa_init(byte bank0) throws IOException {
 
//	int i = 0;
//	int data0 = 0;
//	int data1 = 0;

//	try {
//		Thread.sleep(1);
//	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	try {
//		device.write((byte)(0x00));
//	} catch (IOException e) {
		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
//	System.out.println("INIT SENSOR...");

	
//	pa_init(BANK0);
//	int HEX = 0x00;
	
//	System.out.print("Addr0 =");
//	System.out.print(data0);
//	System.out.print(",  Addr1 =");
//	System.out.println(data1);

//	if ( (data0 != 0x20 ) || (data1 != 0x76) )
//	{
//		return 0xff;
//	}
//	if ( data0 == 0x20 )
//	{
//		System.out.println("wake-up finish.");
//	}
	
//	for (i = 0; i < data0; i++) 
//	{
//		paj7620WriteReg(initRegisterArray[i][0], initRegisterArray[i][1]);
//	}
	
//	paj7620SelectBank(BANK0);  //gesture flage reg in Bank0
	
//	System.out.println("Paj7620 initialize register finished.");
//	return 0;
//}


//private static void paj7620WriteReg(char c, char d) {
	// TODO Auto-generated method stub
	
	
//		try {
//			device.write((byte) 0x43);
//		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		// start transmission to device 
		//write cmd
//		try {
//			device.write((byte) c);
//		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}						// send register address
//		try {
//			device.write((byte) d);
//		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}						// send value to write
	  
	
//}

//private static int paj7620ReadReg(int i, int size, int data0) {
	// TODO Auto-generated method stubuint8_t error;
//	int PAJ7620_ID = 0x73;
	//device.write((byte) 0x00);
//	try {
//		device.write((byte) PAJ7620_ID);
//	} catch (IOException e1) {
		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}
	//pa_init error ; 

//	byte tab[]= new byte[size];
	
	//for (int i=0; i<size; i++)
//	try {
//		device.read(  tab ,0x00, size);
//	} catch (IOException e) {
		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}

	
//	return 0x00;
//}



public static void paj7620SelectBank(int bank)
{
    switch(bank){
		case BANK0:
			device.write(PAJ7620_REGITER_BANK_SEL, PAJ7620_BANK0);
			break;
		case BANK1:
			device.write(PAJ7620_REGITER_BANK_SEL, PAJ7620_BANK1);
			break;
		default:
			break;
	}
}

//private static void paj7620WriteReg(byte paj7620RegiterBankSel,byte paj7620Bank0) {
	// TODO Auto-generated method stub
//	try {
//		device.write((byte) 0x43);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}		// start transmission to device 
	//write cmd
//	try {
//		device.write((byte) paj7620RegiterBankSel);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}						// send register address
//	try {
//		device.write((byte) paj7620Bank0);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}	
//}
public void run(){
	int GES_REACTION_TIME=		500	;
	int  GES_ENTRY_TIME	=		800	;
	int GES_QUIT_TIME	=		1000;
int length =0; 
byte  data[]={0};
final byte PAJ7620_I2C_WAKEUP=PAJ7620_VAL(1,0);
final byte PAJ7620_I2C_SUSPEND=PAJ7620_VAL(0,0);
final byte GES_RIGHT_FLAG = 0x01;
final byte GES_LEFT_FLAG = 0x02;
final byte GES_UP_FLAG = 0x04;
final byte GES_DOWN_FLAG = 0x08;
final byte GES_FORWARD_FLAG = 0x10;
final byte GES_BACKWARD_FLAG = 0x20;
final byte GES_CLOCKWISE_FLAG = 0x40;
final byte GES_COUNT_CLOKWISE_FLAG = (byte) 0x80;
final byte GES_WAVE_FLAG = 0x01;
				// Read Bank_0_Reg_0x43/0x44 for gesture result.
while(true)
{

	
device.write((byte)0x43);
	length=device.read(data,0x00,1);
	
	if (length>0){
	
			switch (data0[0] ) 									// When different gestures be detected, the variable 'data' will be set to different values by paj7620ReadReg(0x43, 1, &data).
			{
				case GES_RIGHT_FLAG:
				try {
					Thread.sleep(GES_ENTRY_TIME);
					IHM1.lbldroi.setBackground(Color.ORANGE);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					device.write((byte)0x43);
					device.read(data,0x00,1);
					if(data0[0]  == GES_FORWARD_FLAG) 
					{
						System.out.println("Forward");
						IHM1.lbldroi.setBackground(Color.ORANGE);
						try {
							Thread.sleep(GES_QUIT_TIME);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					else if(data0[0]  == GES_BACKWARD_FLAG) 
					{
						System.out.println("Backward");
						IHM1.lblgau.setBackground(Color.ORANGE);
						try {
							Thread.sleep(GES_QUIT_TIME);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					{
						System.out.println("Right");
						IHM1.lbldroi.setBackground(Color.ORANGE);
						try {
							Thread.sleep(GES_QUIT_TIME);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}          
					break;
				case GES_LEFT_FLAG: 
				try {
					Thread.sleep(GES_ENTRY_TIME);
				} catch (InterruptedException e10) {
					// TODO Auto-generated catch block
					e10.printStackTrace();
				}
					device.write((byte)0x43);
					device.read(data,0x00,1);
					if(data0[0]  == GES_FORWARD_FLAG) 
					{
						System.out.println("Forward");
						IHM1.lblforward.setBackground(Color.ORANGE);
						try {
							Thread.sleep(GES_QUIT_TIME);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if(data0[0]  == GES_BACKWARD_FLAG) 
					{
						System.out.println("Backward");
						IHM1.lblbackward.setBackground(Color.ORANGE);
						try {
							Thread.sleep(GES_QUIT_TIME);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
					{
						System.out.println("Left");
						IHM1.lblgau.setBackground(Color.ORANGE);
						try {
							Thread.sleep(GES_QUIT_TIME);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}          
					break;
				case GES_UP_FLAG:
				try {
					Thread.sleep(GES_ENTRY_TIME);
				} catch (InterruptedException e9) {
					// TODO Auto-generated catch block
					e9.printStackTrace();
				}
					device.write((byte)0x43);
					device.read(data,0x00,1);
					if(data0[0]  == GES_FORWARD_FLAG) 
					{
						System.out.println("Forward");
						IHM1.lblforward.setBackground(Color.ORANGE);
						try {
							Thread.sleep(GES_QUIT_TIME);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if(data0[0]  == GES_BACKWARD_FLAG) 
					{
						System.out.println("Backward");
						IHM1.lblbackward.setBackground(Color.ORANGE);
						try {
							Thread.sleep(GES_QUIT_TIME);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
					{
						System.out.println("Up");
						IHM1.lblup.setBackground(Color.ORANGE);
						try {
							Thread.sleep(GES_QUIT_TIME);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}          
					break;
				case GES_DOWN_FLAG:
				try {
					Thread.sleep(GES_ENTRY_TIME);
				} catch (InterruptedException e8) {
					// TODO Auto-generated catch block
					e8.printStackTrace();
				}
					device.write((byte)0x43);
					device.read(data,0x00,1);
					if(data0[0]  == GES_FORWARD_FLAG) 
					{
						System.out.println("Forward");
						IHM1.lblforward.setBackground(Color.ORANGE);
						try {
							Thread.sleep(GES_QUIT_TIME);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if(data0[0]  == GES_BACKWARD_FLAG) 
					{
						System.out.println("Backward");
						IHM1.lblbackward.setBackground(Color.ORANGE);
						try {
							Thread.sleep(GES_QUIT_TIME);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
					{
						System.out.println("Down");
						IHM1.lbldown.setBackground(Color.ORANGE);
						try {
							Thread.sleep(GES_QUIT_TIME);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}          
					break;
				case GES_FORWARD_FLAG:
				try {
					Thread.sleep(GES_ENTRY_TIME);
				} catch (InterruptedException e7) {
					// TODO Auto-generated catch block
					e7.printStackTrace();
				}
					System.out.println("Forward");
					IHM1.lblforward.setBackground(Color.ORANGE);
				try {
					Thread.sleep(GES_QUIT_TIME);
				} catch (InterruptedException e6) {
					// TODO Auto-generated catch block
					e6.printStackTrace();
				}
					break;
				case GES_BACKWARD_FLAG:	
				try {
					Thread.sleep(GES_ENTRY_TIME);
				} catch (InterruptedException e5) {
					// TODO Auto-generated catch block
					e5.printStackTrace();
				}
					System.out.println("Backward");
					IHM1.lblbackward.setBackground(Color.ORANGE);
				try {
					Thread.sleep(GES_QUIT_TIME);
				} catch (InterruptedException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
					break;
				case GES_CLOCKWISE_FLAG:
				try {
					Thread.sleep(GES_ENTRY_TIME);
				} catch (InterruptedException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
					System.out.println("Clockwise");
					IHM1.lblclock1.setBackground(Color.ORANGE);
				try {
					Thread.sleep(GES_QUIT_TIME);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
					break;
				case GES_COUNT_CLOKWISE_FLAG:
				try {
					Thread.sleep(GES_ENTRY_TIME);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					System.out.println("anti-clockwise");
					IHM1.lblclock2.setBackground(Color.ORANGE);
				try {
					Thread.sleep(GES_QUIT_TIME);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					break;  
				default:
				try {
					Thread.sleep(GES_ENTRY_TIME);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					device.write((byte)0x44);
					device.read(data,0x00,1);
					if (data1[0]  == GES_WAVE_FLAG) 
					{
						System.out.println("wave");
						IHM1.lblwave.setBackground(Color.ORANGE);
						
					}
					break;
			}
		}
		
	}

}

}
