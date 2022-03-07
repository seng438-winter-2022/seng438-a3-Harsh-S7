package org.jfree.data;

import static org.junit.Assert.assertEquals;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class TestDataUtilities extends DataUtilities{

	 @Before
	 public void setUp() throws Exception { 
	    }
	 
		@Test
		public void testSimple() {
			//fail("Not yet implemented");
			DefaultCategoryDataset data = new DefaultCategoryDataset();
			Integer first = 0;
			Integer second = 0;
			data.addValue(0.5, first, second);
			first=1;
			data.addValue(2,first, second);
			double value = DataUtilities.calculateColumnTotal(data, second);
			//System.out.println("Value "+value);
			assertEquals(2.5,value,.000000001d);
		}
		
		@Test
		public void testDecimal() {
			//fail("Not yet implemented");
			DefaultCategoryDataset data = new DefaultCategoryDataset();
			Integer first = 0;
			Integer second = 0;
			data.addValue(0.63, first, second);
			first=1;
			data.addValue(2.32,first, second);
			double value = DataUtilities.calculateColumnTotal(data, second);
			//System.out.println("Value "+value);
			assertEquals(2.95,value,.000000001d);
		}
	 
		@Test
		public void doubleTest() {
			double[][] testCase = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
			Number[][] result = DataUtilities.createNumberArray2D(testCase);
			// verify
			boolean check = false;

			for (int i = 0; i < result.length; i++)
				for (int j = 0; j < result[i].length; j++)
					if (result[i][j].doubleValue() != testCase[i][j]) {
						check = true;
						break;
					}
			assertEquals(false, check);
		}
		
		@Test
		public void testDifSizes() {
			double[][] testCase = { { 1 }, { 2, 3, 4, 5, 6 }, { 7, 8, 9,10,11,12,13,14,15,16 } };
			Number[][] result = DataUtilities.createNumberArray2D(testCase);
			// verify
			boolean check = false;

			for (int i = 0; i < result.length; i++)
				for (int j = 0; j < result[i].length; j++)
					if (result[i][j].doubleValue() != testCase[i][j]) {
						check = true;
						break;
					}
			assertEquals(false, check);
		}
		
		@Test
		public void testDecimals() {
			double[][] testCase = { { 1, 1.11 }, { 2, 2.63, 3, 4, 5.322, 5, 6 }, { 7, 8, 9,10,11,12,13,14,15,16 } };
			Number[][] result = DataUtilities.createNumberArray2D(testCase);
			// verify
			boolean check = false;

			for (int i = 0; i < result.length; i++)
				for (int j = 0; j < result[i].length; j++)
					if (result[i][j].doubleValue() != testCase[i][j]) {
						check = true;
						break;
					}
			assertEquals(false, check);
		}
		
		@Test
		public void testIntvalues() {
			double[][] testCase = { { 1 }, { 2.77777777777, 3, 4, 5, 6 }, { 7, 8, 9,10,11,12,13,14,15,16 } };
			Number[][] result = DataUtilities.createNumberArray2D(testCase);
			// verify
			boolean check = false;

			for (int i = 0; i < result.length; i++)
				for (int j = 0; j < result[i].length; j++)
					if (result[i][j].intValue() != (int)testCase[i][j]) {
						check = true;
						break;
					}
			assertEquals(false, check);
		}
		
		@Test
		public void testCorrectArray() {
			//fail("Not yet implemented");
			double [] arr = {2.0,4.5,6.5,4.5,7.6};
			Number [] value = DataUtilities.createNumberArray(arr);
			boolean check = false;
			if(value.length!=arr.length) {
				check = true;
			}else {
				for(int i=0;i<value.length;i++) {
					if(value[i].doubleValue()!=arr[i]) {
						check = true;
						break;
					}
				}
			}
			assertEquals(false,check);
			
		}
		
		@Test
		public void testChangedArray() {
			//fail("Not yet implemented");
			double [] arr = {3.0,4.57,6.45,4.45,7.46};
			Number [] value = DataUtilities.createNumberArray(arr);
			boolean check = false;
			arr[3]=1.223;   
			if(value.length!=arr.length) {
				check = true;
			}else {
				for(int i=0;i<value.length;i++) {
					if(value[i].doubleValue()!=arr[i]) {
						check = true;
						break;
					}
				}
			}
			assertEquals(true,check);
			
		}
		
		@Test
		// testing and simulating the forloop
		public void testMultiple() {
			Mockery mockinger = new Mockery();
			final KeyedValues values = mockinger.mock(KeyedValues.class);
			mockinger.checking(new Expectations() {
				{
					// first loop that sets the values
					allowing(values).getItemCount();
					will(returnValue(3));

					allowing(values).getValue(0);
					will(returnValue(-7.5));

					allowing(values).getItemCount();
					will(returnValue(3));

					allowing(values).getValue(1);
					will(returnValue(2.5));

					allowing(values).getItemCount();
					will(returnValue(3));

					allowing(values).getValue(2);
					will(returnValue(-5.0));

					allowing(values).getItemCount();
					will(returnValue(3));

					// 2nd loop that sets the keys
					allowing(values).getItemCount();
					will(returnValue(3));

					allowing(values).getKey(0);
					will(returnValue(4));

					allowing(values).getKey(1);
					will(returnValue(-3));

					allowing(values).getItemCount();
					will(returnValue(3));

					allowing(values).getKey(2);
					will(returnValue(0));

				}
			});

			KeyedValues result = DataUtilities.getCumulativePercentages(values);

			assertEquals((double) result.getValue(0), 7.5 / 10.0, .000000001d);
		}
		
		
		@Test
		public void testValue() {
			Mockery mockinger = new Mockery();
			final KeyedValues values = mockinger.mock(KeyedValues.class);
			mockinger.checking(new Expectations() {
				{

					allowing(values).getValue(0);
					will(returnValue(7.5));

					allowing(values).getItemCount();
					will(returnValue(1));

					allowing(values).getKey(0);
					will(returnValue(0));
				}
			});

			KeyedValues result = DataUtilities.getCumulativePercentages(values);

			assertEquals((double) result.getValue(0), 1.0, .000000001d);
		}
		
		@Test
		public void testRowTwo() {
			//fail("Not yet implemented");
			Mockery mockingContext = new Mockery();
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {
		        {
		            one(values).getColumnCount();
		            will(returnValue(2));
		            one(values).getValue(0, 0);
		            will(returnValue(7.5));
		            one(values).getValue(0, 1);
		            will(returnValue(2.5));
		        }
		    });
		    double result = DataUtilities.calculateRowTotal(values, 0);
		    // verify
		    assertEquals(result, 10, .000000001d);
			
		}
		
		
		@Test
		public void testRowThree() {
			//fail("Not yet implemented");
			Mockery mockingContext = new Mockery();
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {
		        {
		            one(values).getColumnCount();
		            will(returnValue(3));
		            one(values).getValue(0, 0);
		            will(returnValue(6.23));
		            one(values).getValue(0, 1);
		            will(returnValue(1.58));
		            one(values).getValue(0, 2);
		            will(returnValue(4.52));
		        }
		    });
		    double result = DataUtilities.calculateRowTotal(values, 0);
		    // verify
		    assertEquals(result, 12.33, .000000001d);
			
		}	
		
		@Test
		public void testRowThreeNull() {
			//fail("Not yet implemented");
			Mockery mockingContext = new Mockery();
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {
		        {
		            one(values).getColumnCount();
		            will(returnValue(3));
		            one(values).getValue(0, 0);
		            will(returnValue(null));
		            one(values).getValue(0, 1);
		            will(returnValue(1.58));
		            one(values).getValue(0, 2);
		            will(returnValue(4.52));
		        }
		    });
		    double result = DataUtilities.calculateRowTotal(values, 0);
		    // verify
		    assertEquals(result, 6.1, .000000001d);
			
		}	
		
		@Test
		public void testCalcualteRowTotal(){
			Mockery mockingContext = new Mockery();
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {
		        {
		            one(values).getColumnCount();
		            will(returnValue(3));
		            one(values).getValue(0, 0);
		            will(returnValue(6.23));
		            one(values).getValue(0, 1);
		            will(returnValue(1.58));
		            one(values).getValue(0, 2);
		            will(returnValue(4.52));
		        }
		    });
		    int[] testArr=new int[3];
		    testArr[0]=0;
		    testArr[1]=2;
		    testArr[2]=1;
		    double result = DataUtilities.calculateRowTotal(values, 0,testArr);
		    assertEquals(result, 12.33, .000000001d);
		    
		}
		
		@Test
        public void testCalculateColumn_longerArray(){
            Mockery mockingContext = new Mockery();
            final Values2D values = mockingContext.mock(Values2D.class);
            mockingContext.checking(new Expectations() {
                {
                    one(values).getRowCount();
                    will(returnValue(3));
                    one(values).getValue(0, 0);
                    will(returnValue(6.23));
                    one(values).getValue(1, 0);
                    will(returnValue(1.58));
                    one(values).getValue(2, 0);
                    will(returnValue(4.52));
                }
            });
            int[] testArr=new int[4];
            testArr[0]=0;
            testArr[1]=2;
            testArr[2]=1;
            testArr[3]=3;
            double result = DataUtilities.calculateColumnTotal(values, 0,testArr);
            assertEquals(result, 12.33, .000000001d);
            
        }
		
        @Test
        public void testCalculateRow_longerArray(){
            Mockery mockingContext = new Mockery();
            final Values2D values = mockingContext.mock(Values2D.class);
            mockingContext.checking(new Expectations() {
                {
                    one(values).getColumnCount();
                    will(returnValue(3));
                    one(values).getValue(0, 0);
                    will(returnValue(6.23));
                    one(values).getValue(0, 1);
                    will(returnValue(1.58));
                    one(values).getValue(0, 2);
                    will(returnValue(4.52));
                }
            });
            int[] testArr=new int[4];
            testArr[0]=0;
            testArr[1]=2;
            testArr[2]=1;
            testArr[3]=3;
            double result = DataUtilities.calculateRowTotal(values, 0,testArr);
            assertEquals(result, 12.33, .000000001d);
            
        }
        
		@Test
		public void testCalcualteRowTotal_1Index(){
			Mockery mockingContext = new Mockery();
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {
		        {
		            one(values).getColumnCount();
		            will(returnValue(3));
		            one(values).getValue(0, 0);
		            will(returnValue(6.23));
		            one(values).getValue(0, 1);
		            will(returnValue(1.58));
		            one(values).getValue(0, 2);
		            will(returnValue(4.52));
		        }
		    });
		    int[] testArr=new int[1];
		    testArr[0]=1;
		    
		    double result = DataUtilities.calculateRowTotal(values, 0,testArr);
		    assertEquals(result, 1.58, .000000001d);
		    
		}
		@Test
		public void testCalcualteRowTotal_indexesOutOfOrder(){
			Mockery mockingContext = new Mockery();
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {
		        {
		            one(values).getColumnCount();
		            will(returnValue(3));
		            one(values).getValue(0, 0);
		            will(returnValue(6.23));
		            one(values).getValue(0, 1);
		            will(returnValue(1.58));
		            one(values).getValue(0, 2);
		            will(returnValue(4.52));
		        }
		    });
		    int[] testArr=new int[3];
		    testArr[0]=0;
		    testArr[1]=1;
		    testArr[2]=2;
		    double result = DataUtilities.calculateRowTotal(values, 0,testArr);
		    assertEquals(result, 12.33, .000000001d);
		    
		}
		
		
		@Test
		public void testCalculateColumnTotal(){
			Mockery mockingContext = new Mockery();
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {
		        {
		            one(values).getRowCount();
		            will(returnValue(3));
		            one(values).getValue(0, 0);
		            will(returnValue(6.23));
		            one(values).getValue(1, 0);
		            will(returnValue(1.58));
		            one(values).getValue(2, 0);
		            will(returnValue(4.52));
		        }
		    });
		    int[] testArr=new int[3];
		    testArr[0]=0;
		    testArr[1]=2;
		    testArr[2]=1;
		    double result = DataUtilities.calculateColumnTotal(values, 0,testArr);
		    assertEquals(result, 12.33, .000000001d);
		    
		}

		@Test
		public void testCalculateColumnTotal_1Index(){
			Mockery mockingContext = new Mockery();
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {
		        {
		        	one(values).getRowCount();
		            will(returnValue(3));
		            one(values).getValue(0, 0);
		            will(returnValue(6.23));
		            one(values).getValue(1, 0);
		            will(returnValue(1.58));
		            one(values).getValue(2, 0);
		            will(returnValue(4.52));
		        }
		    });
		    int[] testArr=new int[1];
		    testArr[0]=0;
		    
		    double result = DataUtilities.calculateColumnTotal(values, 0,testArr);
		    assertEquals(result, 6.23, .000000001d);
		    
		}
		@Test
		public void testCalculateColumnTotal_indexesOutOfOrder(){
			Mockery mockingContext = new Mockery();
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {
		        {
		            one(values).getRowCount();
		            will(returnValue(3));
		            one(values).getValue(0, 0);
		            will(returnValue(6.23));
		            one(values).getValue(1, 0);
		            will(returnValue(1.58));
		            one(values).getValue(2, 0);
		            will(returnValue(4.52));
		        }
		    });
		    int[] testArr=new int[3];
		    testArr[0]=0;
		    testArr[1]=2;
		    testArr[2]=1;

		    double result = DataUtilities.calculateColumnTotal(values, 0,testArr);
		    assertEquals(result, 12.33, .000000001d);
		    
		}
		
		
		@Test
		public void testEqual() {
			double arr1[][]=new double[2][2];
			double arr2[][]=new double[2][2];
			arr1[0][0]=1;
			arr1[0][1]=2;
			arr2[0][0]=1;
			arr2[0][1]=2;
			arr1[1][0]=2;
			arr1[1][1]=1;
			arr2[1][0]=2;
			arr2[1][1]=1;
			boolean result=DataUtilities.equal(arr1, arr2);
			assertEquals(result,true);		
		}
		
		@Test
		public void testEqual_unequal() {
			double arr1[][]=new double[2][2];
			double arr2[][]=new double[2][2];
			arr1[0][0]=2;
			arr1[0][1]=2;
			arr2[0][0]=1;
			arr2[0][1]=2;
			arr1[1][0]=2;
			arr1[1][1]=1;
			arr2[1][0]=2;
			arr2[1][1]=1;
			boolean result=DataUtilities.equal(arr1, arr2);
			assertEquals(result,false);		
		}
		
		@Test
		public void testEqualUnequal() {
			double arr1[][]=new double[2][2];
			double arr2[][]=new double[1][1];
			arr1[0][0]=2;
			arr1[0][1]=2;
			arr2[0][0]=1;
			arr1[1][0]=2;
			arr1[1][1]=1;
			boolean result=DataUtilities.equal(arr1, arr2);
			assertEquals(result,false);		
		}
		
		public void testEqualFirstNull() {
			double arr1[][] = null;
			double arr2[][] = null;
			boolean result=DataUtilities.equal(arr1, arr2);
			assertEquals(result,true);		
		}
		
		
		@Test
		public void testEqual_multipleUnequal() {
			double arr1[][]=new double[2][2];
			double arr2[][]=new double[2][2];
			arr1[0][0]=2;
			arr1[0][1]=1;
			arr2[0][0]=1;
			arr2[0][1]=1;
			arr1[1][0]=2;
			arr1[1][1]=1;
			arr2[1][0]=2;
			arr2[1][1]=1;
			boolean result=DataUtilities.equal(arr1, arr2);
			assertEquals(result,false);		
		}
		//expected to fail....
		@Test
		public void testEqual_wrongLengths() {
			double arr1[][]=new double[2][2];
			double arr2[][]=new double[2][1];
			arr1[0][0]=2;
			arr1[0][1]=1;
			arr2[0][0]=1;
			arr1[1][0]=2;
			arr1[1][1]=1;
			arr2[1][0]=2;
			
			boolean result=DataUtilities.equal(arr1, arr2);
			assertEquals(result,false);		
		}
		@Test
		public void testEqual_wrongLengthsSwitched() {
			double arr1[][]=new double[2][1];
			double arr2[][]=new double[2][2];
			arr2[0][0]=2;
			arr2[0][1]=1;
			arr1[0][0]=1;
			arr2[1][0]=2;
			arr2[1][1]=1;
			arr1[1][0]=2;
			
			boolean result=DataUtilities.equal(arr1, arr2);
			assertEquals(result,false);		
		}
		
		@Test
		public void testEqual_1Value() {
			double arr1[][]=new double[2][1];
			double arr2[][]=new double[2][1];
			arr1[0][0]=1;
			
			arr2[0][0]=1;
			
			
			boolean result=DataUtilities.equal(arr1, arr2);
			assertEquals(result,true);		
		}
		@Test
		public void testEqual_null() {
			double arr1[][]=null;
			double arr2[][]=null;
			boolean result=DataUtilities.equal(arr1, arr2);
			assertEquals(result,true);
		}
		@Test
		public void testEqual_empty() {
			double arr1[][]=new double[1][2];
			double arr2[][]=new double[1][2];
			boolean result=DataUtilities.equal(arr1, arr2);
			assertEquals(result,true);
		}
		@Test
		public void testEqual_emptyAndNull() {
			double arr1[][]=new double[1][2];
			double arr2[][]=null;
			boolean result=DataUtilities.equal(arr1, arr2);
			assertEquals(result,false);
		}
		
		
		
		@Test
		public void testClone() {
			double[][] orig=new double[2][2];
			orig[0][0]=1;
			orig[0][1]=2;
			orig[1][0]=1;
			orig[1][1]=2;
			
			double[][] newArr=DataUtilities.clone(orig);
			boolean a=true;
			for(int i=0;i<orig.length;i++)
				for(int j=0;j<orig[i].length;j++)
					if(orig[i][j]!=newArr[i][j])
						a=false;
			assertEquals(a,true);
			
		}
		

		
		
		@After	   
		public void tearDown() throws Exception {
	    }
		

	    @AfterClass
	    public static void tearDownAfterClass() throws Exception {
	    }
}

