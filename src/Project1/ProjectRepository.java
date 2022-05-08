package Project1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class ProjectRepository {
	static List<ProjectDTO> pl = new ArrayList<>();
	Scanner scan = new Scanner(System.in);

	public Boolean idCheck(String id) {
		Boolean check = true;
		for (int i = 0; i < pl.size(); i++) {
			if (id.equals(pl.get(i).getId())) {
				check = false;
			}
		}
		return check;
	}

	void save(ProjectDTO pd) {
		pl.add(pd);

	}

	public ProjectDTO login(String id, String password) {
		ProjectDTO check = null;
		for (int i = 0; i < pl.size(); i++) {
			if (id.equals(pl.get(i).getId()) && password.equals(pl.get(i).getPassword())) {
				check = pl.get(i);
			}
		}
		return check;
	}

	public Long findChip(String id) {
		Long findC = null;
		for (int i = 0; i < pl.size(); i++) {
			if (id.equals(pl.get(i).getId())) {
				findC = pl.get(i).getChip();
			}
		}
		return findC;
	}

	public void addChip(String id, Long add) {
		for (int i = 0; i < pl.size(); i++) {
			if (id.equals(pl.get(i).getId())) {
				pl.get(i).setChip(pl.get(i).getChip() + add);
			}
		}

	}

	public void game(ProjectDTO login) {

		if (login.getChip() >= 5) { // 최소 칩 갯수 5개
			List<CardDTO> cl = new ArrayList<>();
			List<MyCardDTO> md = new ArrayList<>();
			List<maintainDTO> mtd = new ArrayList<>();
			List<otherDTO> od = new ArrayList<>();
			// 덱 생성
			System.out.println("덱 셔플중입니다.");
			String[] mark = { "♧", "♡", "◆", "♠" };
			String[] num = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
			Long marValue = 0l;
			for (int i = 0; i < mark.length; i++) {
				marValue++;
				Long numValue = 1l;
				for (int j = 0; j < num.length; j++) {
					numValue++;
					CardDTO cd = new CardDTO(mark[i], num[j], marValue, numValue);
					cl.add(cd);
				}
			}
			// 인게임 3장받고 4장깔기 : 3장받고 바닥에 1개깔리고 1장공개 -> 배팅(칩+1개) -> 1장깔고 1장받고 -> 배팅(칩+1개) ->
			// 1장깔고 마지막배팅(칩+2개) -> 결과
			// 0~51
			System.out.println("카드를 돌리시겠습니까? || (칩 1개 배팅 , 현재 칩 갯수 : " + login.getChip() + "개 )");
			System.out.println("1.Yes | 2.No");
			System.out.print("입력 > ");
			Long tableChip = 2l;
			int choice1 = scan.nextInt();
			if (choice1 == 1) {
				// 3 , 1 , 3
				login.setChip(login.getChip() - 1l); // 칩 1개 소모

				int deal = (int) (Math.random() * (cl.size() - 1));
				for (int j = 0; j == 0; j++) {
					deal = (int) (Math.random() * (cl.size() - 1));
					maintainDTO mtd1 = new maintainDTO(cl.get(deal).getMark(), cl.get(deal).getNum(),
							cl.get(deal).getMarkNum(), cl.get(deal).getNumNum());
					mtd.add(mtd1);
					cl.remove(deal);
					for (int i = 0; i < 3; i++) {
						deal = (int) (Math.random() * (cl.size() - 1));
						MyCardDTO md1 = new MyCardDTO(cl.get(deal).getMark(), cl.get(deal).getNum(),
								cl.get(deal).getMarkNum(), cl.get(deal).getNumNum());
						md.add(md1);
						cl.remove(deal);
						deal = (int) (Math.random() * (cl.size() - 1));
						otherDTO od1 = new otherDTO(cl.get(deal).getMark(), cl.get(deal).getNum(),
								cl.get(deal).getMarkNum(), cl.get(deal).getNumNum());
						od.add(od1);
						cl.remove(deal);
					}
				}
				// 카드 출력
				System.out.print(" 내 카드 : ");
				for (int i = 0; i < md.size(); i++) {
					System.out.print(md.get(i).getMark() + md.get(i).getNum() + " ");
				}
				System.out.println();
				System.out.print("중립 카드 : ");
				for (int i = 0; i < mtd.size(); i++) {
					System.out.print(mtd.get(i).getMark() + mtd.get(i).getNum() + " ");
				}
				System.out.println();
				System.out.print("상대 카드 : ");
				System.out.println(od.get(0).getMark() + od.get(0).getNum() + " **" + " **");

				// 배팅
				System.out.println("현재 배팅된 칩 : " + tableChip + "개");
				System.out.println("카드를 돌리시겠습니까? || (칩 1개 배팅 , 현재 칩 갯수 : " + login.getChip() + "개 )");
				System.out.println("1.Yes | 2.No");
				System.out.print("입력 > ");
				choice1 = scan.nextInt();
				if (choice1 == 1) {
					// 4 , 2 , 4
					login.setChip(login.getChip() - 1l); // 칩 1개 소모
					tableChip += 2l;
					// 카드 나누기
					deal = (int) (Math.random() * (cl.size() - 1));
					maintainDTO mtd1 = new maintainDTO(cl.get(deal).getMark(), cl.get(deal).getNum(),
							cl.get(deal).getMarkNum(), cl.get(deal).getNumNum());
					mtd.add(mtd1);
					cl.remove(deal);

					deal = (int) (Math.random() * (cl.size() - 1));
					MyCardDTO md1 = new MyCardDTO(cl.get(deal).getMark(), cl.get(deal).getNum(),
							cl.get(deal).getMarkNum(), cl.get(deal).getNumNum());
					md.add(md1);
					cl.remove(deal);
					deal = (int) (Math.random() * (cl.size() - 1));
					otherDTO od1 = new otherDTO(cl.get(deal).getMark(), cl.get(deal).getNum(),
							cl.get(deal).getMarkNum(), cl.get(deal).getNumNum());
					od.add(od1);
					cl.remove(deal);

					// 카드 출력
					System.out.print(" 내 카드 : ");
					for (int i = 0; i < md.size(); i++) {
						System.out.print(md.get(i).getMark() + md.get(i).getNum() + " ");
					}
					System.out.println();
					System.out.print("중립 카드 : ");
					for (int i = 0; i < mtd.size(); i++) {
						System.out.print(mtd.get(i).getMark() + mtd.get(i).getNum() + " ");
					}
					System.out.println();
					System.out.print("상대 카드 : ");
					int randomChoin = (int) (Math.random() * 3) + 1;
					System.out.println(od.get(0).getMark() + od.get(0).getNum() + " " + od.get(randomChoin).getMark()
							+ od.get(randomChoin).getNum() + " **" + " **");

					// 배팅
					System.out.println("현재 배팅된 칩 : " + tableChip + "개");
					System.out.println("카드를 돌리시겠습니까? || (칩 1개 배팅 , 현재 칩 갯수 : " + login.getChip() + "개 )");
					System.out.println("1.Yes | 2.No");
					System.out.print("입력 > ");
					choice1 = scan.nextInt();

					if (choice1 == 1) {
						// 4 , 3 , 4
						login.setChip(login.getChip() - 1l); // 칩 1개 소모
						tableChip += 2l;
						// 카드 나누기
						mtd1 = new maintainDTO(cl.get(deal).getMark(), cl.get(deal).getNum(), cl.get(deal).getMarkNum(),
								cl.get(deal).getNumNum());
						mtd.add(mtd1);
						cl.remove(deal);
						// 카드 출력
						System.out.print(" 내 카드 : ");
						for (int i = 0; i < md.size(); i++) {
							System.out.print(md.get(i).getMark() + md.get(i).getNum() + " ");
						}
						System.out.println();
						System.out.print("중립 카드 : ");
						for (int i = 0; i < mtd.size(); i++) {
							System.out.print(mtd.get(i).getMark() + mtd.get(i).getNum() + " ");
						}
						System.out.println();
						System.out.print("상대 카드 : ");
						System.out.println(od.get(0).getMark() + od.get(0).getNum() + " "
								+ od.get(randomChoin).getMark() + od.get(randomChoin).getNum() + " **" + " **");

						// 배팅
						System.out.println("현재 배팅된 칩 : " + tableChip + "개");
						System.out.println("마지막 배팅을 하시겠습니까? || (칩 2개 배팅 , 현재 칩 갯수 : " + login.getChip() + "개 )");
						System.out.println("1.Yes | 2.No");
						System.out.print("입력 > ");
						choice1 = scan.nextInt();
						if (choice1 == 1) {
							List<SaveDTO> sl = new ArrayList<>();
							login.setChip(login.getChip() - 2l); // 칩 1개 소모
							tableChip += 4l;

							for (int i = 0; i < mtd.size(); i++) {
								md1 = new MyCardDTO(mtd.get(i).getMark(), mtd.get(i).getNum(), mtd.get(i).getMarkNum(),
										mtd.get(i).getNumNum());
								md.add(md1);
								od1 = new otherDTO(mtd.get(i).getMark(), mtd.get(i).getNum(), mtd.get(i).getMarkNum(),
										mtd.get(i).getNumNum());
								od.add(od1);
							} // 각 리스트에 카드 넣기.
							for (int i = 0; i < md.size(); i++) {
								SaveDTO sd = new SaveDTO(md.get(i).getMarkNum(), md.get(i).getNumNum());
								sl.add(sd);
							} // 내 카드덱 완성

							Long Value = 0l; // 족보 값
							Long MaxCard = 0l; // 최대 수 값
							Long MaxMark = 0l; // 최고 모양 값
							Long MyAdd =0l;
							int clover = 0;
							int heart = 0;
							int dia = 0;
							int space = 0;
							// clover = 1, heart = 2, dia = 3, space= 4;
							for (int i = 0; i < 7; i++) {
								if (sl.get(i).getMarkNum() == 1) {
									clover++;
								} else if (sl.get(i).getMarkNum() == 2) {
									heart++;
								}
								if (sl.get(i).getMarkNum() == 3) {
									dia++;
								}
								if (sl.get(i).getMarkNum() == 4) {
									space++;
								}
							} // 플러시 체크
							int count = 0;
							if (clover >= 5) {
								MaxMark = 1l;
								count = clover;
							} else if (heart >= 5) {
								MaxMark = 2l;
								count = heart;
							} else if (dia >= 5) {
								MaxMark = 3l;
								count = dia;

							} else if (space >= 5) {
								MaxMark = 4l;
								count = space;
							}
							if (count >= 5) {
								if (Value <= 6) {
									Value = 6l;
									for (int i = 0; i < sl.size(); i++) {
										if (sl.get(i).getMarkNum() == MaxMark) {
											if (MaxCard < sl.get(i).getNumNum()) {
												MaxCard = sl.get(i).getNumNum();
											}
										}
									}
								}
							} // 플러쉬
							Long[] check = new Long[count];
							if (count >= 5) {
								int count2 = 0;
								for (int i = 0; i < sl.size(); i++) {
									if (sl.get(i).getMarkNum() == MaxMark) {
										check[count2] = sl.get(i).getMarkNum();
										count2++;
									}
								}

								Long save = 0l;
								for (int i = 0; i < check.length; i++) {
									for (int j = 0; j < check.length; j++) {
										if (check[i] > check[j]) {
											save = check[i];
											check[i] = check[j];
											check[j] = save;
										}
									}
								} // 오름차순 정렬
								MyAdd = check[0] +check[1] +check[2] +check[3] +check[4]; // 가장 큰 숫자가 같을때
							} // 플러쉬인 값 받아놓기
							if (count >= 5) {
								if (check[0] + check[1] + check[2] + check[3] + check[4] == 60) {
									Value = 10l;
									MaxCard = check[0];
								}
							} // 로티플
							if (count >= 5) {
								for (int i = 0; i < check.length - 4l; i++) {
									if (check[i] - 1l == check[i + 1] && check[i] - 2l == check[i + 2]
											&& check[i] - 3l == check[i + 3] && check[i] - 4l == check[i + 4]) {
										if (Value < 9) {
											Value = 9l;
											MaxCard = check[i];
										}
									}
								}
							} // 스티플

							Long a1 = 0l, b2 = 0l, c3 = 0l, d4 = 0l, e5 = 0l, f6 = 0l, g7 = 0l, h8 = 0l, i9 = 0l,
									j10 = 0l, k11 = 0l, l12 = 0l, m13 = 0l;

							for (int i = 0; i < 7; i++) {
								if (sl.get(i).getNumNum() == 2l) {
									a1++;
								} else if (sl.get(i).getNumNum() == 3l) {
									b2++;
								} else if (sl.get(i).getNumNum() == 4l) {
									c3++;
								} else if (sl.get(i).getNumNum() == 5l) {
									d4++;
								} else if (sl.get(i).getNumNum() == 6l) {
									e5++;
								} else if (sl.get(i).getNumNum() == 7l) {
									f6++;
								} else if (sl.get(i).getNumNum() == 8l) {
									g7++;
								} else if (sl.get(i).getNumNum() == 9l) {
									h8++;
								} else if (sl.get(i).getNumNum() == 10l) {
									i9++;
								} else if (sl.get(i).getNumNum() == 11l) {
									j10++;
								} else if (sl.get(i).getNumNum() == 12l) {
									k11++;
								} else if (sl.get(i).getNumNum() == 13l) {
									l12++;
								} else if (sl.get(i).getNumNum() == 14l) {
									m13++;
								}
							} // 각 카드마다 갯수 정리
							Long[] card = { a1, b2, c3, d4, e5, f6, g7, h8, i9, j10, k11, l12, m13 };

							for (int i = 0; i < card.length; i++) {
								if (card[i] == 4) {
									if (Value < 8) {
										Value = 8l;
										MaxMark = 0l;
										MaxCard = i + 2l;
									}
								}
							} // 포카드
							for (int i = 0; i < card.length; i++) {
								for (int j = 0; j < card.length; j++) {
									if (card[i] == 3) {
										if (i != j && card[j] == 2) {
											if (Value <= 7l) {
												Value = 7l;
												MaxCard = i + 2l;
												MaxMark = j + 2l; // 풀하우스는 트리플 값 같으면 더블의 값으로 계산
											}
										}
										if (Value < 4l) {
											Value = 4l;
											MaxCard = i + 2l; // 트리플
										}
									}
								}
							} // 풀하우스

							// 스트레이트
							Long[] arr = { sl.get(0).getNumNum(), sl.get(1).getNumNum(), sl.get(2).getNumNum(),
									sl.get(3).getNumNum(), sl.get(4).getNumNum(), sl.get(5).getNumNum(),
									sl.get(6).getNumNum() };
							ArrayList<Long> aL = new ArrayList<>();
							for (Long l : arr) {
								if (!aL.contains(l)) {
									aL.add(l);
								}
							} // 중복제거

							Long save2 = 0l;
							Long[] arr2 = new Long[aL.size()];
							for (int i = 0; i < aL.size(); i++) {
								arr2[i] = aL.get(i);
							}

							for (int i = 0; i < arr2.length; i++) {
								for (int j = 0; j < arr2.length; j++) {
									if (arr2[i] > arr2[j]) {
										save2 = arr2[i];
										arr2[i] = arr2[j];
										arr2[j] = save2;
									}
								}
							} // 정렬
							if (arr2.length >= 5) {
								for (int i = 0; i < arr2.length - 4; i++) {
									if (arr2[i] == arr2[i + 1] + 1 && arr2[i + 1] == arr2[i + 2] + 1
											&& arr2[i + 2] == arr2[i + 3] + 1 && arr2[i + 3] == arr2[i + 4] + 1) {
										if (Value < 5) {
											Value = 5l;
											MaxCard = arr2[i];
											for (int j = 0; j < sl.size(); j++) {
												if (arr2[i] == sl.get(j).getNumNum()) {
													if (MaxMark < sl.get(j).getMarkNum()) {
														MaxMark = sl.get(j).getMarkNum();
													}
												}
											}
										}
									}
								} // 스트레이트
								if (arr2[0] + arr2[arr2.length - 1] + arr2[arr2.length - 2] + arr2[arr2.length - 3]
										+ arr2[arr2.length - 4] == 28) {
									if (Value <= 5) {
										Value = 5l;
										MaxCard = arr2[0];
										for (int i = 0; i < sl.size(); i++) {
											if (arr2[0] == sl.get(i).getNumNum()) {
												if (MaxMark < sl.get(i).getMarkNum()) {
													MaxMark = sl.get(i).getMarkNum();
												}
											}
										}
									}
								} // 백스트레이트

							}

							for (int i = 0; i < card.length; i++) {
								for (int j = 0; j < card.length; j++) {
									if (card[i] == 2) {
										if (i != j && card[j] == 2) {
											if (Value < 3) {
												Value = 3l;
												if (i > j) {
													MaxCard = i + 2l;
												} else {
													MaxCard = i + 2l;
												}
											}
										} // 투페어
										if (Value < 2) {
											Value = 2l;
											MaxCard = i + 2l;
										}
									} // 원페어
								}
								if (card[i] == 1) {
									if (Value <= 1) {
										Value = 1l;
										MaxCard = i + 2l;
									}
								}
							} // 탑
							Long myValue = Value; // 내 Value값 받기
							Long myMaxCard = MaxCard; // 내 MaxCard값 받기
							Long myMaxMark = MaxMark; // 내 MaxMark값 받기

							// 상대카드
							sl = new ArrayList<>();// 리스트지우기

							for (int i = 0; i < md.size(); i++) {
								SaveDTO sd1 = new SaveDTO(od.get(i).getMarkNum(), od.get(i).getNumNum());
								sl.add(sd1);
							} // 상대 카드덱 완성

							Value = 0l; // 족보 값
							MaxCard = 0l; // 최대 수 값
							MaxMark = 0l; // 최고 모양 값
							Long otherAdd=0l;

							clover = 0;
							heart = 0;
							dia = 0;
							space = 0;
							// clover = 1, heart = 2, dia = 3, space= 4;
							for (int i = 0; i < 7; i++) {
								if (sl.get(i).getMarkNum() == 1) {
									clover++;
								} else if (sl.get(i).getMarkNum() == 2) {
									heart++;
								}
								if (sl.get(i).getMarkNum() == 3) {
									dia++;
								}
								if (sl.get(i).getMarkNum() == 4) {
									space++;
								}
							} // 플러시 체크
							count = 0;
							if (clover >= 5) {
								MaxMark = 1l;
								count = clover;
							} else if (heart >= 5) {
								MaxMark = 2l;
								count = heart;
							} else if (dia >= 5) {
								MaxMark = 3l;
								count = dia;

							} else if (space >= 5) {
								MaxMark = 4l;
								count = space;
							}
							if (count >= 5) {
								if (Value <= 6) {
									Value = 6l;
									for (int i = 0; i < sl.size(); i++) {
										if (sl.get(i).getMarkNum() == MaxMark) {
											if (MaxCard < sl.get(i).getNumNum()) {
												MaxCard = sl.get(i).getNumNum();
											}
										}
									}
								}
							} // 플러쉬
							check = new Long[count];
							if (count >= 5) {
								int count2 = 0;
								for (int i = 0; i < sl.size(); i++) {
									if (sl.get(i).getMarkNum() == MaxMark) {
										check[count2] = sl.get(i).getMarkNum();
										count2++;
									}
								}

								Long save = 0l;
								for (int i = 0; i < check.length; i++) {
									for (int j = 0; j < check.length; j++) {
										if (check[i] > check[j]) {
											save = check[i];
											check[i] = check[j];
											check[j] = save;
										}
									}
								} // 오름차순 정렬
								otherAdd = check[0] +check[1] +check[2] +check[3] +check[4]; 
							} // 플러쉬인 값 받아놓기
							if (count >= 5) {
								if (check[0] + check[1] + check[2] + check[3] + check[4] == 60) {
									Value = 10l;
									MaxCard = check[0];
								}
							} // 로티플
							if (count >= 5) {
								for (int i = 0; i < check.length - 4l; i++) {
									if (check[i] - 1l == check[i + 1] && check[i] - 2l == check[i + 2]
											&& check[i] - 3l == check[i + 3] && check[i] - 4l == check[i + 4]) {
										if (Value < 9) {
											Value = 9l;
											MaxCard = check[i];
										}
									}
								}
							} // 스티플

							a1 = 0l;
							b2 = 0l;
							c3 = 0l;
							d4 = 0l;
							e5 = 0l;
							f6 = 0l;
							g7 = 0l;
							h8 = 0l;
							i9 = 0l;
							j10 = 0l;
							k11 = 0l;
							l12 = 0l;
							m13 = 0l;

							for (int i = 0; i < 7; i++) {
								if (sl.get(i).getNumNum() == 2l) {
									a1++;
								} else if (sl.get(i).getNumNum() == 3l) {
									b2++;
								} else if (sl.get(i).getNumNum() == 4l) {
									c3++;
								} else if (sl.get(i).getNumNum() == 5l) {
									d4++;
								} else if (sl.get(i).getNumNum() == 6l) {
									e5++;
								} else if (sl.get(i).getNumNum() == 7l) {
									f6++;
								} else if (sl.get(i).getNumNum() == 8l) {
									g7++;
								} else if (sl.get(i).getNumNum() == 9l) {
									h8++;
								} else if (sl.get(i).getNumNum() == 10l) {
									i9++;
								} else if (sl.get(i).getNumNum() == 11l) {
									j10++;
								} else if (sl.get(i).getNumNum() == 12l) {
									k11++;
								} else if (sl.get(i).getNumNum() == 13l) {
									l12++;
								} else if (sl.get(i).getNumNum() == 14l) {
									m13++;
								}
							} // 각 카드마다 갯수 정리
							Long[] card1 = { a1, b2, c3, d4, e5, f6, g7, h8, i9, j10, k11, l12, m13 };

							for (int i = 0; i < card1.length; i++) {
								if (card1[i] == 4) {
									if (Value < 8) {
										Value = 8l;
										MaxMark = 0l;
										MaxCard = i + 2l;
									}
								}
							} // 포카드
							for (int i = 0; i < card1.length; i++) {
								for (int j = 0; j < card1.length; j++) {
									if (card1[i] == 3) {
										if (i != j && card1[j] == 2) {
											if (Value <= 7l) {
												Value = 7l;
												MaxCard = i + 2l;
												MaxMark = j + 2l; // 풀하우스는 트리플 값 같으면 더블의 값으로 계산
											}
										}
										if (Value < 4l) {
											Value = 4l;
											MaxCard = i + 2l; // 트리플
										}
									}
								}
							} // 풀하우스

							// 스트레이트
							Long[] arr1 = { sl.get(0).getNumNum(), sl.get(1).getNumNum(), sl.get(2).getNumNum(),
									sl.get(3).getNumNum(), sl.get(4).getNumNum(), sl.get(5).getNumNum(),
									sl.get(6).getNumNum() };
							ArrayList<Long> aL1 = new ArrayList<>();
							for (Long l : arr1) {
								if (!aL1.contains(l)) {
									aL1.add(l);
								}
							} // 중복제거

							save2 = 0l;
							Long[] arr21 = new Long[aL1.size()];
							for (int i = 0; i < aL1.size(); i++) {
								arr21[i] = aL1.get(i);
							}

							for (int i = 0; i < arr21.length; i++) {
								for (int j = 0; j < arr21.length; j++) {
									if (arr21[i] > arr21[j]) {
										save2 = arr21[i];
										arr21[i] = arr21[j];
										arr21[j] = save2;
									}
								}
							} // 정렬
							if (arr21.length >= 5) {
								for (int i = 0; i < arr21.length - 4; i++) {
									if (arr21[i] == arr21[i + 1] + 1 && arr21[i + 1] == arr21[i + 2] + 1
											&& arr21[i + 2] == arr21[i + 3] + 1 && arr21[i + 3] == arr21[i + 4] + 1) {
										if (Value < 5) {
											Value = 5l;
											MaxCard = arr21[i];
											for (int j = 0; j < sl.size(); j++) {
												if (arr21[i] == sl.get(j).getNumNum()) {
													if (MaxMark < sl.get(j).getMarkNum()) {
														MaxMark = sl.get(j).getMarkNum();
													}
												}
											}
										}
									}
								} // 스트레이트
								if (arr21[0] + arr21[arr21.length - 1] + arr21[arr21.length - 2]
										+ arr21[arr21.length - 3] + arr21[arr21.length - 4] == 28) {
									if (Value <= 5) {
										Value = 5l;
										MaxCard = arr21[0];
										for (int i = 0; i < sl.size(); i++) {
											if (arr21[0] == sl.get(i).getNumNum()) {
												if (MaxMark < sl.get(i).getMarkNum()) {
													MaxMark = sl.get(i).getMarkNum();
												}
											}
										}
									}
								} // 백스트레이트

							}

							for (int i = 0; i < card1.length; i++) {
								for (int j = 0; j < card1.length; j++) {
									if (card1[i] == 2) {
										if (i != j && card1[j] == 2) {
											if (Value <= 3) {
												Value = 3l;
												if (i > j) {
													MaxCard = i + 2l;
												} else {
													MaxCard = i + 2l;
												}
											}
										} // 투페어
										if (Value <= 2) {
											Value = 2l;
											MaxCard = i + 2l;
										}
									} // 원페어
								}
								if (card1[i] == 1) {
									if (Value <= 1) {
										Value = 1l;
										MaxCard = i + 2l;
									}
								}
							} // 탑
								/////////////////////////
							Long otherValue = Value;
							Long otherMaxCard = MaxCard;
							Long otherMaxMark = MaxMark;

							System.out.print(" 내 카드 : ");
							for (int i = 0; i < 4; i++) {
								System.out.print(md.get(i).getMark() + md.get(i).getNum() + " ");
							}
							System.out.println();
							
							System.out.print("중립 카드 : ");
							for (int i = 0; i < mtd.size(); i++) {
								System.out.print(mtd.get(i).getMark() + mtd.get(i).getNum() + " ");
							}
							System.out.println();
							
							System.out.print("상대 카드 :");
							for (int i = 0; i < 4; i++) {
								System.out.print(od.get(i).getMark() + od.get(i).getNum() + " ");
							};
							System.out.println();
							
							String[] valueArr = { "탑", "원페어", "투페어", "트리플", "스트레이트", "플러쉬", "풀하우스", "포카드", "스티플",
									"로티플" };
							String[] numArr = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
							System.out.println("나 : " + numArr[(int) (myMaxCard - 2)] + valueArr[(int) (myValue - 1)]); // 내 패 출력
																															
							System.out.println(
									"상대 : " + numArr[(int) (otherMaxCard - 2)] + valueArr[(int) (otherValue - 1)]); // 상대 패 출력

							// 결과
							if (myValue > otherValue) {
								System.out.println("승리하셨습니다.");
								login.setWin(login.getWin() + 1l);
								login.setChip(login.getChip() + tableChip);
								System.out.println("현재 칩 갯수 : " + login.getChip() + "개 ");
							} else if (myValue == otherValue) {
								if (myMaxCard > otherMaxCard) {
									System.out.println("승리하셨습니다.");
									login.setWin(login.getWin() + 1l);
									login.setChip(login.getChip() + tableChip);
									System.out.println("현재 칩 갯수 : " + login.getChip() + "개 ");
								} else if (myMaxCard == otherMaxCard) {
									if (myMaxMark > otherMaxMark) {
										System.out.println("승리하셨습니다.");
										login.setWin(login.getWin() + 1l);
										login.setChip(login.getChip() + tableChip);
										System.out.println("현재 칩 갯수 : " + login.getChip() + "개 ");
									} else if (myMaxCard==otherMaxCard) {
										if(MyAdd>otherAdd) {
											System.out.println("승리하셨습니다.");
											login.setWin(login.getWin() + 1l);
											login.setChip(login.getChip() + tableChip);
											System.out.println("현재 칩 갯수 : " + login.getChip() + "개 ");
										}else {
											System.out.println("패배하셨습니다.");
											login.setLose(login.getLose() + 1l);
											System.out.println("현재 칩 갯수 : " + login.getChip() + "개 ");
										}
									} else {
										System.out.println("패배하셨습니다.");
										login.setLose(login.getLose() + 1l);
										System.out.println("현재 칩 갯수 : " + login.getChip() + "개 ");
									}
								} else {
									System.out.println("패배하셨습니다.");
									login.setLose(login.getLose() + 1l);
									System.out.println("현재 칩 갯수 : " + login.getChip() + "개 ");
								}
							} else {
								System.out.println("패배하셨습니다.");
								login.setLose(login.getLose() + 1l);
								System.out.println("현재 칩 갯수 : " + login.getChip() + "개 ");
							}

						} else {
							System.out.println("패배하셨습니다.");
							login.setLose(login.getLose() + 1l);
							System.out.println("현재 칩 갯수 : " + login.getChip() + "개 ");
						}
					} else {
						System.out.println("패배하셨습니다.");
						login.setLose(login.getLose() + 1l);
						System.out.println("현재 칩 갯수 : " + login.getChip() + "개 ");
					}

				} else {
					System.out.println("패배하셨습니다.");
					login.setLose(login.getLose() + 1l);
					System.out.println("현재 칩 갯수 : " + login.getChip() + "개 ");
				}
			} else {
				System.out.println("종료합니다.");
			}
		} else {
			System.out.println("칩 갯수가 부족합니다.");
		}
	}
}
